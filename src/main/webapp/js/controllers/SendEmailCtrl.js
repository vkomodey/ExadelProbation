/**
 * Created by Administrator on 07.08.2014.
 */
var FeedbacksCtrl = studentsControllers.controller('SendEmailCtrl', ['$scope', '$http',
    function($scope, $http) {
        $scope.sendEmail = function() {
            var email = {
                id: $scope.makeIdsArray($scope.checkedStudHash),
                message: $scope.message,
                password: $scope.password,
                title: $scope.title
            };
            $http.post('/rest/send/email', email).success(function () {
                alert('Email is sent');
            })
                .error(function (status, data) {
                    alert('Error' + data);
                });
        }
    }]);