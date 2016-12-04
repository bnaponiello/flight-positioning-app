angular.module("flightPositioning").factory("flightsApi", function($http, parameters) {
   var _getFlights = function() {
       return $http.get(parameters.baseUrl + parameters.flightsRequest);
   };

   var _findFlightByIdent = function(ident) {
       if (ident) {
           return $http.get(parameters.baseUrl + parameters.flightsRequest + "?ident=" + ident);
       } else {
           return _getFlights();
       }
   };

   var _findFlightByFlightId = function(flightId) {
       if (flightId) {
           return $http.get(parameters.baseUrl + parameters.flightsRequest + "/" + flightId);
       } else {
           return null;
       }
   };

   var _findFlights = function(flightRequest) {
       if (flightRequest) {
           var endpoint = parameters.baseUrl + parameters.flightsRequest;
           var queryParams = null;
           if (flightRequest.ident) {
               queryParams = "ident=" + flightRequest.ident;
           }
           if (flightRequest.airlineName) {
               if (queryParams) {
                   queryParams = queryParams + "&";
               } else {
                   queryParams = "";
               }
               queryParams = queryParams + "airlineName=" + flightRequest.airlineName;
           }
           if (queryParams) {
               endpoint = endpoint + "?" + queryParams;
           }
           return $http.get(endpoint);
       } else {
           return _getFlights();
       }
   };

   return {
       getFlights: _getFlights,
       findFlightByIdent: _findFlightByIdent,
       findFlightByFlightId: _findFlightByFlightId,
       findFlights: _findFlights
   };
});