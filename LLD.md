# Shopping Mall — Domain Model

## 1. Mall

```
══════════════════════════════════════════════
                 MALL
══════════════════════════════════════════════

ATTRIBUTES

  mallId
  name
  address
  openingHours
  totalStores
  establishedDate


RELATIONSHIPS

CARDINALITY        OBJECT

1 : N               Store
1 : N               Category
1 : N               Promotion


CARDINALITY        ACTOR / USER

1 : N               MallAdmin
1 : N               SecurityStaff


ACTIONS                         ACTORS / USERS

registerStore()                 → MallAdmin
approveStore()                  → MallAdmin
removeStore()                   → MallAdmin
viewMallInfo()                  → Customer, Guest


STATE

  Active
  UnderRenovation
  Closed


STATE TRANSITIONS

  Active → renovate → UnderRenovation
  UnderRenovation → completeRenovation → Active
  Active → close → Closed


BUSINESS RULES

  A mall must have at least one active store to operate
  Only MallAdmin can approve or reject store registration
  Closed mall hides all stores from Customer/Guest view
```

---

## 2. Store

```
══════════════════════════════════════════════
                 STORE
══════════════════════════════════════════════

ATTRIBUTES

  storeId
  name
  ownerId
  categoryId
  location (floor/unit)
  rating
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Mall
1 : N               Product
1 : N               Order
1 : N               Review
1 : N               Promotion


CARDINALITY        ACTOR / USER

1 : 1               StoreOwner
N : 1               MallAdmin
1 : N               Cashier


ACTIONS                         ACTORS / USERS

createStore()                   → StoreOwner
updateStore()                   → StoreOwner
addProduct()                    → StoreOwner
approveStore()                  → MallAdmin
suspendStore()                  → MallAdmin


STATE

  PendingApproval
  Active
  Suspended
  Closed


STATE TRANSITIONS

  PendingApproval → approve → Active
  Active → suspend → Suspended
  Suspended → reinstate → Active
  Active → close → Closed


BUSINESS RULES

  Store must be approved by MallAdmin before it can sell
  Suspended store cannot list new products
  Store rating is computed from average of Product/Review ratings
```

---

## 3. Product

```
══════════════════════════════════════════════
                 PRODUCT
══════════════════════════════════════════════

ATTRIBUTES

  productId
  name
  description
  price
  sku
  categoryId
  storeId
  images[]


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Store
N : 1               Category
1 : 1               Inventory
1 : N               Review
N : N               Cart
N : N               Order
N : N               Promotion


CARDINALITY        ACTOR / USER

N : 1               StoreOwner
N : N               Customer


ACTIONS                         ACTORS / USERS

addProduct()                    → StoreOwner
editProduct()                   → StoreOwner
deleteProduct()                 → StoreOwner
viewProduct()                   → Customer, Guest
addToCart()                     → Customer
addToWishlist()                 → Customer


STATE

  Draft
  Published
  OutOfStock
  Discontinued


STATE TRANSITIONS

  Draft → publish → Published
  Published → stockDepletes → OutOfStock
  OutOfStock → restock → Published
  Published → discontinue → Discontinued


BUSINESS RULES

  Product cannot be published without at least one image
  Price must be greater than 0
  OutOfStock products are hidden from search unless the customer opts into "notify me"
```

---

## 4. Category

```
══════════════════════════════════════════════
                 CATEGORY
══════════════════════════════════════════════

ATTRIBUTES

  categoryId
  name
  parentCategoryId (nullable)
  icon


RELATIONSHIPS

CARDINALITY        OBJECT

1 : N               Product
1 : 1               Category (parent, self-referencing)
1 : N               Category (subcategories)


CARDINALITY        ACTOR / USER

N : 1               MallAdmin


ACTIONS                         ACTORS / USERS

createCategory()                → MallAdmin
editCategory()                  → MallAdmin
deleteCategory()                → MallAdmin


STATE               (not applicable)

BUSINESS RULES

  A category cannot be deleted while it has active products
  Category hierarchy depth is capped (e.g. max 3 levels)
```

---

## 5. Inventory / Stock

```
══════════════════════════════════════════════
                 INVENTORY
══════════════════════════════════════════════

ATTRIBUTES

  inventoryId
  productId
  quantityAvailable
  quantityReserved
  warehouseLocation
  lastUpdated


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               Product


CARDINALITY        ACTOR / USER

N : 1               WarehouseStaff


ACTIONS                         ACTORS / USERS

updateStock()                   → WarehouseStaff
reserveStock()                  → System (on order placement)
releaseStock()                  → System (on cancellation)


STATE

  InStock
  LowStock
  OutOfStock


STATE TRANSITIONS

  InStock → quantityBelowThreshold → LowStock
  LowStock → quantityReachesZero → OutOfStock
  LowStock/OutOfStock → restock → InStock


BUSINESS RULES

  Reserved stock is released automatically if an order is cancelled within the reservation window
  Stock quantity can never go negative
```

---

## 6. Cart

```
══════════════════════════════════════════════
                 CART
══════════════════════════════════════════════

ATTRIBUTES

  cartId
  customerId
  items[]
  totalPrice
  updatedAt


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               Customer
N : N               Product


CARDINALITY        ACTOR / USER

1 : 1               Customer


ACTIONS                         ACTORS / USERS

addItem()                       → Customer
removeItem()                    → Customer
updateQuantity()                → Customer
checkout()                      → Customer


STATE

  Active
  CheckedOut
  Abandoned


STATE TRANSITIONS

  Active → checkout → CheckedOut
  Active → inactivityTimeout → Abandoned


BUSINESS RULES

  Cart items are removed automatically if the product becomes unavailable
  Abandoned carts expire after a fixed period of inactivity (e.g. 30 days)
```

---

## 7. Order

```
══════════════════════════════════════════════
                 ORDER
══════════════════════════════════════════════

ATTRIBUTES

  orderId
  customerId
  storeId
  items[]
  totalAmount
  orderDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Customer
N : 1               Store
1 : 1               Payment
1 : 1               Delivery
1 : 1               Invoice
N : N               Product
0 : 1               Refund


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               Cashier
N : 1               StoreOwner
N : 1               DeliveryStaff


ACTIONS                         ACTORS / USERS

placeOrder()                    → Customer
cancelOrder()                   → Customer
confirmOrder()                  → StoreOwner
prepareOrder()                  → StoreOwner, WarehouseStaff
shipOrder()                     → DeliveryStaff


STATE

  Placed
  Confirmed
  Preparing
  Shipped
  Delivered
  Cancelled
  Returned


STATE TRANSITIONS

  Placed → confirm → Confirmed
  Confirmed → prepare → Preparing
  Preparing → ship → Shipped
  Shipped → deliver → Delivered
  Placed/Confirmed → cancel → Cancelled
  Delivered → return → Returned


BUSINESS RULES

  An order cannot be cancelled once it has shipped
  Payment must succeed before an order can move to Confirmed
  Stock is reserved when Placed and deducted when Confirmed
```

---

## 8. Payment

```
══════════════════════════════════════════════
                 PAYMENT
══════════════════════════════════════════════

ATTRIBUTES

  paymentId
  orderId
  amount
  method
  status
  transactionDate


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               Order


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               Finance


ACTIONS                         ACTORS / USERS

initiatePayment()               → Customer
confirmPayment()                → System (payment gateway)
refundPayment()                 → Finance


STATE

  Pending
  Success
  Failed
  Refunded


STATE TRANSITIONS

  Pending → success → Success
  Pending → fail → Failed
  Success → refund → Refunded


BUSINESS RULES

  Order cannot move to Confirmed unless payment status is Success
  Failed payments allow a retry within a limited window (e.g. 15 minutes)
```

---

## 9. Invoice / Receipt

```
══════════════════════════════════════════════
                 INVOICE
══════════════════════════════════════════════

ATTRIBUTES

  invoiceId
  orderId
  issueDate
  items[]
  totalAmount
  taxAmount


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               Order
1 : 1               Payment


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               Finance


ACTIONS                         ACTORS / USERS

generateInvoice()               → System
downloadInvoice()                → Customer


STATE               (not applicable — immutable once issued)

BUSINESS RULES

  Invoice is generated automatically once payment succeeds
  Invoice content cannot be edited after issuance
```

---

## 10. Delivery

```
══════════════════════════════════════════════
                 DELIVERY
══════════════════════════════════════════════

ATTRIBUTES

  deliveryId
  orderId
  address
  courier
  trackingNumber
  estimatedDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               Order
1 : 1               Address


CARDINALITY        ACTOR / USER

N : 1               DeliveryStaff
N : 1               Customer


ACTIONS                         ACTORS / USERS

assignDelivery()                → DeliveryStaff
updateStatus()                  → DeliveryStaff
trackDelivery()                 → Customer


STATE

  Pending
  PickedUp
  InTransit
  Delivered
  Failed


STATE TRANSITIONS

  Pending → pickup → PickedUp
  PickedUp → transit → InTransit
  InTransit → deliver → Delivered
  InTransit → deliveryFails → Failed


BUSINESS RULES

  Delivery status is visible to the customer in real time
  A failed delivery triggers an automatic retry, up to a maximum number of attempts
```

---

## 11. Refund / Return

```
══════════════════════════════════════════════
                 REFUND / RETURN
══════════════════════════════════════════════

ATTRIBUTES

  refundId
  orderId
  reason
  amount
  requestDate
  status


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               Order
0 : 1               Payment


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               SupportAgent
N : 1               Finance


ACTIONS                         ACTORS / USERS

requestRefund()                 → Customer
approveRefund()                 → SupportAgent
rejectRefund()                  → SupportAgent
processRefund()                 → Finance


STATE

  Requested
  Approved
  Rejected
  Processed


STATE TRANSITIONS

  Requested → approve → Approved
  Requested → reject → Rejected
  Approved → process → Processed


BUSINESS RULES

  Refunds can only be requested within a fixed window after delivery (e.g. 7 days)
  The store owner must be notified whenever a return request is filed
```

---

## 12. Review

```
══════════════════════════════════════════════
                 REVIEW
══════════════════════════════════════════════

ATTRIBUTES

  reviewId
  productId
  customerId
  comment
  rating (1–5)
  date


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Product
N : 1               Order (verifies purchase)


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               SupportAgent


ACTIONS                         ACTORS / USERS

writeReview()                   → Customer
editReview()                    → Customer
deleteReview()                  → Customer
moderateReview()                → SupportAgent


STATE

  Pending
  Published
  Removed


STATE TRANSITIONS

  Pending → approve → Published
  Pending/Published → remove → Removed


BUSINESS RULES

  Only customers who purchased the product may review it
  One review per customer per product
```

---

## 13. Rating

```
══════════════════════════════════════════════
                 RATING
══════════════════════════════════════════════

ATTRIBUTES

  ratingId
  targetType (Product / Store)
  targetId
  customerId
  score (1–5)


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Product
N : 1               Store


CARDINALITY        ACTOR / USER

N : 1               Customer


ACTIONS                         ACTORS / USERS

submitRating()                  → Customer


STATE               (not applicable)

BUSINESS RULES

  A target's (Product/Store) average score recalculates whenever a rating is added or changed
  A customer may submit only one rating per target
```

---

## 14. Wishlist

```
══════════════════════════════════════════════
                 WISHLIST
══════════════════════════════════════════════

ATTRIBUTES

  wishlistId
  customerId
  productIds[]


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               Customer
N : N               Product


CARDINALITY        ACTOR / USER

1 : 1               Customer


ACTIONS                         ACTORS / USERS

addToWishlist()                 → Customer
removeFromWishlist()            → Customer
moveToCart()                    → Customer


STATE               (not applicable)

BUSINESS RULES

  Customer is notified when a wishlist item goes on sale or comes back in stock
```

---

## 15. Promotion / Campaign

```
══════════════════════════════════════════════
                 PROMOTION
══════════════════════════════════════════════

ATTRIBUTES

  promoId
  name
  discountType
  discountValue
  startDate
  endDate
  applicableProducts[]


RELATIONSHIPS

CARDINALITY        OBJECT

N : N               Product
N : N               Store
1 : N               Coupon


CARDINALITY        ACTOR / USER

N : 1               MarketingTeam
N : 1               MallAdmin


ACTIONS                         ACTORS / USERS

createPromotion()               → MarketingTeam
editPromotion()                 → MarketingTeam
approvePromotion()              → MallAdmin


STATE

  Draft
  Scheduled
  Active
  Expired


STATE TRANSITIONS

  Draft → schedule → Scheduled
  Scheduled → startDateReached → Active
  Active → endDateReached → Expired


BUSINESS RULES

  A promotion cannot conflict with another active discount on the same product
  Maximum discount is capped by mall-wide policy (e.g. 70%)
```

---

## 16. Coupon

```
══════════════════════════════════════════════
                 COUPON
══════════════════════════════════════════════

ATTRIBUTES

  couponId
  code
  promoId
  discountValue
  usageLimit
  expiryDate
  usedCount


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Promotion
N : N               Order


CARDINALITY        ACTOR / USER

N : 1               MarketingTeam
N : N               Customer


ACTIONS                         ACTORS / USERS

createCoupon()                  → MarketingTeam
applyCoupon()                   → Customer


STATE

  Active
  Expired
  Exhausted


STATE TRANSITIONS

  Active → usageLimitReached → Exhausted
  Active → expiryDatePassed → Expired


BUSINESS RULES

  Coupon usage is limited to one redemption per customer unless stated otherwise
  Coupon is invalid if cart total is below the minimum threshold
```

---

## 17. Notification

```
══════════════════════════════════════════════
                 NOTIFICATION
══════════════════════════════════════════════

ATTRIBUTES

  notificationId
  recipientId
  type
  message
  sentDate
  readStatus


RELATIONSHIPS

CARDINALITY        OBJECT

0 : 1               Order
0 : 1               Promotion
0 : 1               Complaint


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               StoreOwner


ACTIONS                         ACTORS / USERS

sendNotification()              → System
markAsRead()                    → Customer, StoreOwner


STATE

  Unread
  Read


STATE TRANSITIONS

  Unread → open → Read


BUSINESS RULES

  Critical notifications (order status, payment) cannot be disabled by the user
```

---

## 18. Complaint / Ticket

```
══════════════════════════════════════════════
                 COMPLAINT / TICKET
══════════════════════════════════════════════

ATTRIBUTES

  ticketId
  customerId
  orderId (nullable)
  subject
  description
  priority
  status


RELATIONSHIPS

CARDINALITY        OBJECT

0 : 1               Order


CARDINALITY        ACTOR / USER

N : 1               Customer
N : 1               SupportAgent


ACTIONS                         ACTORS / USERS

raiseComplaint()                → Customer
assignTicket()                  → SupportAgent
resolveTicket()                 → SupportAgent


STATE

  Open
  InProgress
  Resolved
  Closed


STATE TRANSITIONS

  Open → assign → InProgress
  InProgress → resolve → Resolved
  Resolved → close → Closed
  Resolved → reopen → InProgress


BUSINESS RULES

  Unresolved tickets escalate automatically after a fixed period (e.g. 48 hours)
  Customer can reopen a resolved ticket within a limited window (e.g. 3 days)
```

---

## 19. Address

```
══════════════════════════════════════════════
                 ADDRESS
══════════════════════════════════════════════

ATTRIBUTES

  addressId
  customerId
  label
  street
  city
  postalCode
  isDefault


RELATIONSHIPS

CARDINALITY        OBJECT

N : 1               Customer
1 : N               Delivery


CARDINALITY        ACTOR / USER

N : 1               Customer


ACTIONS                         ACTORS / USERS

addAddress()                    → Customer
editAddress()                   → Customer
setDefault()                    → Customer
deleteAddress()                 → Customer


STATE               (not applicable)

BUSINESS RULES

  Customer must have at least one address to place an order
  Only one address can be marked as default at a time
```

---

## 20. Wallet

```
══════════════════════════════════════════════
                 WALLET
══════════════════════════════════════════════

ATTRIBUTES

  walletId
  customerId
  balance
  currency
  lastTransactionDate


RELATIONSHIPS

CARDINALITY        OBJECT

1 : 1               Customer
1 : N               Transaction (wallet history)


CARDINALITY        ACTOR / USER

1 : 1               Customer
N : 1               Finance


ACTIONS                         ACTORS / USERS

topUp()                         → Customer
withdraw()                      → Customer
payWithWallet()                 → Customer
auditWallet()                   → Finance


STATE

  Active
  Frozen


STATE TRANSITIONS

  Active → suspiciousActivityDetected → Frozen
  Frozen → unfreeze → Active


BUSINESS RULES

  Wallet balance can never go negative
  A frozen wallet blocks all transactions until a support review clears it
```

---

## Actor Reference

| Actor | Primary Involvement |
|---|---|
| Customer | Cart, Order, Payment, Review, Wishlist, Complaint, Wallet |
| Guest | Product, Mall (view-only) |
| StoreOwner | Store, Product, Order (fulfillment) |
| MallAdmin | Mall, Store approval, Category, Promotion approval |
| Cashier | Order (in-person) |
| DeliveryStaff | Delivery |
| WarehouseStaff | Inventory |
| SupportAgent | Review moderation, Refund, Complaint |
| MarketingTeam | Promotion, Coupon |
| SecurityStaff | Mall (physical security) |
| Finance | Payment, Refund, Wallet audit |