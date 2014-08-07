/**
 * Created by Administrator on 07.08.2014.
 */
var FeedbacksCtrl = studentsControllers.controller('SendEmailCtrl', ['$scope', '$http',
    function($scope, $http) {
        $scope.sendEmail = function() {
            var email = {
                id: $scope.checkedStudArray,
                message: $scope.message
//                object: $scope.title
            };
            /*var myJSONString = JSON.stringify(email);
            var myEscapedJSONString = myJSONString.replace(/\\n/g, "\\n");
            alert(myEscapedJSONString);*/
            $http.post('/rest/send/email', email).success(function () {
                alert('Email is sent');
            })
                .error(function (status, data) {
                    alert('Error' + data);
                });
        }
    }]);