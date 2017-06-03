/**
 * Created by abadi on 5/13/17.
 */

var app = angular.module('app', []);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

app.controller('WeatherController', function($scope, $http) {
        $scope.getWeather = function(zipcode){
            $scope.weather = null;
            $scope.dataAvailable = false; //just to show a note when data is available
            $http.get('/weather/' + zipcode).then(function (response) {
                $scope.weather = response.data;
                if($scope.weather != null || $scope.weather.length > 0){
                    $scope.dataAvailable = true;
                }
            })
    };

});
