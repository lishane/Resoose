var formData = {
    'term': 'food',
    'price': '1,2,3,4'
};

angular.module('formApp', ['ngAnimate', 'ui.router'])


    .config(function ($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('form', {
                url: '',
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

        $urlRouterProvider.otherwise('/home');
    })


    .controller('formController', function ($scope, $http) {
        $scope.formData = formData;
    })

    .controller('resultController', function ($scope, $http) {
        var lat;
        var long;
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {

                lat = position.coords.latitude;
                long = position.coords.longitude;
                console.log(lat);
                console.log(long);

                var randomUrl = '/business/random?term=' + formData.term + '&latitude=' + lat + '&longitude=' + long + '&price=' + formData.price;
                console.log(randomUrl);
                $http.get(randomUrl)
                    .then(function (response) {
                        $scope.data = response.data;
                    });
            });

        }
    });



