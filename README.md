# Puja_Travix_Interview_Test

Link to the Readme Document: https://docs.google.com/document/d/1XlTUTwhJrLKw3dw-POg04HCr1uPW0OMFWjQbfTVn9O4/edit?usp=sharing

BusyFlight Service 

BusyFlight is a service that aggregates various valid flight options for the given input from two suppliers, CrazyAir and ToughJet. This service is designed to scale for more suppliers in the future. The service validates the input request and returns the response sorted by fare, cheapest first.

Key Assumptions and Validations

Flight arrival and departure destinations should be represented by a 3 letter code
Input Date format should be YYYY-MM-DD
Arrival date should not be before departure date 
The service only supports return itineraries 
Dates of travel should not be in the past 
Number of passengers should be in between 1 and 4, both included  
All 5 input parameters are mandatory 
A basic implementation of CrazyAir and ToughJet APIs have been done with test data in a constant data package 

Implementation Overview  

Different steps in the service (Corresponding numbers can be found in the diagram above)

1. The web client sends an HTTP request to the BusyFlight service with the 5 required parameters
2. After Springboot and some custom validation BusyFlightService converts the request into an object and sends it to the request transformer 
3. Request Transformer converts the request object to the supplier  request object for CrazyAir and ToughJet respectively and passes it back to BusyFlightService 
4. BusyFlightService sends the request objects to the Response collector 
5. Response Collector calls the respective services
6. Response Collector collects respective response objects from CrazyAir and ToughJet services 
7. Response Collector passes all the response objects to BusyFlight service 
8. BusyFlightService sends the responses to Response Transformer
9. Response Transformer converts and aggregates different objects into a BusyFlightService object and sends it to BusyFlight Service
10. BusyFlight service applies business logic and sorts the result according to price and sends it back to the client

BusyFlightService Implementation: 

The flights search solution which aggregates flight results initially from 2 different suppliers (CrazyAir and ToughJet) 

Components:

BusyFlightController.java - The  BusyFlightRequest is taken as an input.
There are multiple steps which the request goes through and gives the response back as BusyFlightResponse.
The steps in the controller are :
(i) The request validations.
(ii) Once validated,it uses BusyFlightService to invoke the services and get the response.
 BusyFlightServices.java - It takes the valid request and gives back the response.
It uses the following service to give the response :
(i) TransformSupplierRequest.java : It uses the BusyFlightRequest and converts it do different supplier requests (CrazyAirRequest and ToughJetRequest),so that it can be in a particular supplier request format.
(ii)ResponseCollector.java.java : It uses each supplier request from the above step and hits their endpoints and collects their response.
(iii)TransformBusyFlightResponse.java : Each supplier response collected from the above step is transformed to the BusFlightSupplierResponse.
We sort the BusyFlightResponse according to Fare using a custom comparator and return the response.

Supplier Service Implementation

(i) Sample Input  data is taken for both suppliers : CrazyAir and ToughJet.
(ii) Get api are created to  expose their endpoints with the given request and response in the question.

Changes in the given base code:
BusyFlightsRequest.java :
To get the request according to the format in the que Dates are changed from String to LocalDate with the given format.
Different validations are added to validate the request.
a toString() method is added.
BusyFlightsResponse.java : Added the response class to return the response in the given format.
CrazyAirRequest.java :
Dates are changed from String to LocalDate with the given format.
Different validations are added to validate the request.
a toString() method is added.
 CrazyAirResponse.java : Added a toString().      
 ToughJetRequest.java :
Dates are changed from String to LocalDate with the given format.
Different validations are added to validate the request.
a toString() method is added.
  ToughJetResponse.java : Added a toString().

Future Scalability

Currently, this application has been designed keeping in mind that a future iteration may add more suppliers. Additional suppliers can be supported by making respective changes in only the transformers and collector and adding a corresponding supplier class. No changes would be required in BusyFlight Service. 
Further changes can be made to the application to make it more scalable in case the number of suppliers grows.

Changes in the supplied application code

1. Dates in String are converted to LocalDate so that we have the same 
request format
2. Annotations are added so that we can validate the input easily using spring annotations.
 	3. toString() is added so that we can print the current state of an instance. 

Example Request and Response

Request 
http://localhost:8080/busyFlight/flights?origin=ams&destination=par&departureDate=2020-03-11&returnDate=2020-03-13&numberOfPassengers=4

Response :
[
   {
      "airline":"Emirates",
      "supplier":"CrazyAir",
      "fare":76.0,
      "origin":"AMS",
      "destination":"LON",
      "departureDate":"2020-03-10T09:10:00",
      "returnDate":"2020-03-12T09:10:00"
   },
   {
      "airline":"KLM",
      "supplier":"ToughJet",
      "fare":98.75,
      "origin":"AMS",
      "destination":"LON",
      "departureDate":"2020-03-10T09:10:00",
      "returnDate":"2020-03-12T09:10:00"
   },
   {
      "airline":"Etihad",
      "supplier":"CrazyAir",
      "fare":127.0,
      "origin":"AMS",
      "destination":"LON",
      "departureDate":"2020-03-10T09:10:00",
      "returnDate":"2020-03-12T09:10:00"
   },
   {
      "airline":"Transavia",
      "supplier":"ToughJet",
      "fare":187.4,
      "origin":"AMS",
      "destination":"LON",
      "departureDate":"2020-03-10T09:10:00",
      "returnDate":"2020-03-12T09:10:00"
   },
   {
      "airline":"EasyJet",
      "supplier":"ToughJet",
      "fare":226.98,
      "origin":"AMS",
      "destination":"LON",
      "departureDate":"2020-03-10T09:10:00",
      "returnDate":"2020-03-12T09:10:00"
   },
   {
      "airline":"Etihad",
      "supplier":"ToughJet",
      "fare":330.95,
      "origin":"AMS",
      "destination":"LON",
      "departureDate":"2020-03-10T09:10:00",
      "returnDate":"2020-03-12T09:10:00"
   },
   {
      "airline":"EasyJet",
      "supplier":"CrazyAir",
      "fare":370.0,
      "origin":"AMS",
      "destination":"LON",
      "departureDate":"2020-03-10T09:10:00",
      "returnDate":"2020-03-12T09:10:00"
   }
]

Steps to run the application

Download java 8.
Clone the project on your system.
Add the project as a maven project and import all the dependencies.
Build the project by using maven commands  :
 mvn clean
 mv install
Run the application as java application.
You should be able to see Tomcat started on 8080, in case you want to change the port you can do it by specifying it in the application.properties.
Hit the request url mentioned above to see the flight for the given parameters from BusyFlight Service.


	




