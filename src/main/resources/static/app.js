var formData = {
    'term': 'food',
    'price': '1,2,3,4'
};

angular.module('formApp', ['ngAnimate', 'ui.router'])


    .config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise('/resoose/home');

        $stateProvider
            .state('form', {
                url: '/resoose',
                templateUrl: 'form.html',
                controller: 'formController'
            })
            .state('form.home', {
                url: '/home',
                templateUrl: 'form-home.html'
            })

            .state('form.options', {
                url: '/options',
                templateUrl: 'form-options.html'
            })

            .state('form.results', {
                url: '/results',
                templateUrl: 'form-results.html'
            });

    })


    .controller('formController', function ($scope) {
        $scope.formData = formData;
    })

    .controller('resultController', function ($scope, $http, $sce) {
        var lat = 37.7749;
        var long = 122.4194;
        console.log("ran");

        $scope.getMapsSrc = function(mapsQuery) {
            console.log("Map Query");
            return $sce.trustAsResourceUrl("https://www.google.com/maps/embed/v1/place?key=AIzaSyCeMsSd6Yom3eNEH-AiaCO6tNuIvTcDTBw&q=" + mapsQuery);
        };

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {

                lat = position.coords.latitude;
                long = position.coords.longitude;
                console.log(lat);
                console.log(long);

                var randomUrl = '/business/random?term=' + formData.term +'%20food' + '&latitude=' + lat + '&longitude=' + long + '&price=' + formData.price;
                console.log(randomUrl);
                $http.get(randomUrl)
                    .then(function (response) {
                        response.data.location.mapsQuery = response.data.location.address1.replace(/ /g, '+');
                        $scope.data = response.data;
                    });
            });

        }
    });



