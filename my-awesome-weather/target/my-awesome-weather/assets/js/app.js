/**
 * Created by abadi on 5/13/17.
 */

var app = angular.module('app', []);

app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

app.controller('WeatherController', function($scope, $http) {
        $scope.getWeather = function(zipcode){
            $scope.weathers = null;
            $scope.dataAvailable = false; //just to show a note when data is available
            $http.get('/weather/' + zipcode).then(function (response) {
                $scope.weathers = response.data;
                if($scope.weathers != null || $scope.weathers.length > 0){
                    $scope.dataAvailable = true;
                }
            })
    };

});
