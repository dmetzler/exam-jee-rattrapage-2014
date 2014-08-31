'use strict';

angular.module('angularApp')
  .controller('MainCtrl',['$scope','$http', function ($scope, $http) {
    $scope.error = [];

    var refreshScore = function() {
      $http.get("/score").then( function(response) {
      $scope.score = response.data;
    },
    function(response) {
      $scope.error.push([response.status, response.data].join(" : "))
      $scope.error.push("Vous devriez implémenter la méthode doGet() de la servlet.")
      $scope.score = "N/A";
    })
    }

    refreshScore();


    var score = function(p) {
      $scope.error = [];
      $http({
          method: 'POST',
          url: '/score',
          data: $.param({player: p}),
          headers: {'Content-Type': 'application/x-www-form-urlencoded'}
      }).then(function(response) {
        refreshScore();
      },
      function(response) {
        if(response.status == 400) {
          $scope.error.push("Le jeu est terminé")
        } else {
          $scope.error.push([response.status, response.data].join(" : "))
          $scope.error.push("Vous devriez implementer la méthode doPost() de la servlet.")
        }
      });
    }

    $scope.scoreP1 = function() { score("1");}
    $scope.scoreP2 = function() { score("2");}


    $scope.reset = function() {
      $scope.error = [];
      $http.delete("/score").then(function(response) {
        refreshScore();
      },
      function(response) {
        $scope.error.push([response.status, response.data].join(" : "))
        $scope.error.push("Vous devriez implementer la méthode doDelete() de la servlet.")
      });
    }
  }]);
