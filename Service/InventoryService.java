public class InventoryService {

    public void updateStock() {}
    // RBAC: WarehouseStaff

    public void reserveStock() {}
    // RBAC: System (on order placement)

    public void releaseStock() {}
    // RBAC: System (on cancellation)
}
