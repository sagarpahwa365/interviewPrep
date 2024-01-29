List<Vehicle> search(vhicleType, time/date of pickup and drop, pickup point)

POST bookingId bookVehicle(vhicleType, time/date of pickup and drop, pickup point, vehicleId)

POST reschedule(bookingId, vhicleType, time/date of pickup and drop, pickup point, vehicleId)

```mermaid
classDiagram
    class User{
        long id;
        String name;
        String email;
    }
    class VehicleType {
        <<enumeration>>
        BIKE,
        CAR
    }
    class BookingStatus {
        <<enumeration>>
        CREATED,
        CONFIRMED,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED
    }
    class VehicleStatus {
        <<enumeration>>
        AVAILABLE,
        BOOKED
    }
    class Location {
        +long lat
        +long long
        +String address
    }
    class Vehicle {
        +VehicleType type;
        +VehicleStatus status;
        +long id
        +Map<int, double> hourlyPriceMap;
    }
    class Booking {
        Vehicle vehicle;
        Location poickupPoint;
        Location dropPoint;
        DateTime pickupTime;
        DateTime dropTime;
        double driveDist; // dist in km
        User user; 
    }
