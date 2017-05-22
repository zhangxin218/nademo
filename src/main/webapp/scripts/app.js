var MyApp = angular.module('oauthJhipApp', ['ngRoute', 'ngResource', 'ngTable']);

MyApp.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/login', {
        templateUrl: 'scripts/login/login.html',
        controller: 'LoginController'
    });
    
    $routeProvider.when('/device', {
        templateUrl: 'scripts/device/device.html',
        controller: 'DeviceController'
    });
    
    $routeProvider.when('/data', {
        templateUrl: 'scripts/data/data.html',
        controller: 'DataController'
    });

    $routeProvider.otherwise({redirectTo: '/login'});
}]);
