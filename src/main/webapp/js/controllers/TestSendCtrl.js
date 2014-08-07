/**
 * Created by Administrator on 07.08.2014.
 */
studentsControllers.controller('testSend', ['$scope', '$http', function($scope,$http){
    var mas=[{"id":19}, {"id":20}];
    $scope.masJson = angular.toJson(mas);
    $scope.testSendF = function() {
        $http.get('/rest/downloadExcel?ids='+masJson)
            .success(function(data) {
                $scope.data = data;
                alert("success");
                console.log(data);

            })
            .error(function(data,status) {
                alert('ERROR '+ status);
            });
    };

    $scope.testSendPdf = function() {
        $http.get('/rest/downloadPDF?ids='+masJson)
            .success(function() {
                alert("success");
            })
            .error(function(data,status) {
                alert('ERROR '+ status);
            });
    };
}]);