# Parking System design
It's necessary to implement simple in-memory parking lot system.

## Requirements
- there are several vehicle types: motorcycle, car, truck
- there are several spot types: small, compact, large. 
- spot types work as follows:  
small spots can fit only motorcycles  
compact spots fit motorcycles or cars  
large spots fit any vehicle type
- park lot should provide parking and unparking features
- spots capacity is restricted, if unable to park a vehicle, return false

## Optional requirements
- add charging for parking(we can assume that a charge is calculated according to a spot type)
- we're always running out of spots, we can modify out parking spot rules as follows:  
compact spots can fit 2 motorcycles or only 1 car, large spots can fit 3 motorcycles or 1 car and 1 motorcycle or just 1 truck

### Paying attention to the following points
- avoiding the if else blocks, instanceof keyword
- the time complexity for finding a spot

