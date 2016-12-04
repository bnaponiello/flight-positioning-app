angular.module("flightPositioning").controller("flightListController", function ($scope, $http, flightsApi) {
    $scope.app = "Flight Positioning App";
    $scope.flights = [];
    $scope.currentFlight = null;
    $scope.message = "";

    var loadFlights = function() {
        flightsApi.getFlights().success(function(data) {
            $scope.flights = data;
        }).error(function(data, status) {
            $scope.message = "The following error has occurred: " + data + " status: " + status;
        });
    };

    $scope.findFlights = function(flightRequest) {
        flightsApi.findFlights(flightRequest).success(function(data) {
            $scope.flights = data;
        }).error(function(data, status) {
            $scope.message = "The following error has occurred: " + data + " status: " + status;
        });
    };

    $scope.filterFlightsByIdent = function(ident) {
        flightsApi.findFlightByIdent(ident).success(function(data) {
            $scope.flights = data;
        }).error(function(data, status) {
            $scope.message = "The following error has occurred: " + data + " status: " + status;
        });
    };

    $scope.findFlightByFlightId = function(flightId) {
        flightsApi.findFlightByFlightId(flightId).success(function(data) {
            $scope.currentFlight = data;
        }).error(function (data, status) {
            $scope.message = "The following error has occurred: " + data + " status: " + status;
        })
    };

    $scope.formatDate = function(date) {
        var formattedDate = moment(date, "yyyy-MM-dd HH:mm:ss");
        return formattedDate.format("DD") + "/" + formattedDate.format("MM") + "/" + formattedDate.format("YYYY")
    };

    $scope.formatDateInHours = function(date) {
        var formattedDate = moment(date, "yyyy-MM-dd HH:mm:ss");
        return formattedDate.format("HH") + "h" + formattedDate.format("mm")
    };

    $scope.formatDateInDateAndHours = function(date) {
        return $scope.formatDate(date) + " " + $scope.formatDateInHours(date);
    };

    loadFlights();
});