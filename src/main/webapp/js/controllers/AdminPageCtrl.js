var AdminPageCtrl = studentsControllers.controller('AdminPageCtrl', ['$scope', '$routeParams', '$q', '$http', function($scope, $routeParams, $q, $http) {
    AdminPageCtrl.getSkillsList($scope, $http, $q);
    AdminPageCtrl.getUniversityList($scope, $http, $q);
    AdminPageCtrl.getFacultyList($scope, $http, $q);
    $scope.deleteSkillAdm = function (index) {
        AdminPageCtrl.deleteSkillAdm($scope,index);
    };
    $scope.addSkillAdm = function (name) {
        AdminPageCtrl.addSkillAdm($scope, name);
    };
    $scope.sendInfo = function(){
        AdminPageCtrl.sendInfo($scope, $http);
    };
    $scope.addUniversity = function(name){
        AdminPageCtrl.addUniversity($scope, name);
    };
    $scope.deleteUniversity = function (index) {
        AdminPageCtrl.deleteUniversity($scope,index);
    };
    $scope.addFaculty = function(uname, name){
        AdminPageCtrl.addFaculty($scope, uname, name);
    };
    $scope.deleteFaculty = function (index, uname) {
        AdminPageCtrl.deleteFaculty($scope,index, uname);
    };
        }]);
AdminPageCtrl.getSkillsList = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/types/technology/get').success(function (data) {
        $scope.skillNames = data;
    });
    deferred.resolve($scope.skillNames);
};
AdminPageCtrl.deleteSkillAdm = function ($scope, index) {
    $scope.skillNames.splice(index, 1);
};
AdminPageCtrl.addSkillAdm = function ($scope, name) {
    $scope.skillNames.push({
        id: null,
        name: name
    });
};

AdminPageCtrl.getUniversityList = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/types/university/get').success(function (data) {
        $scope.universityNames = data;
    });
    deferred.resolve($scope.universityNames);
};
AdminPageCtrl.addUniversity= function ($scope, name) {
    $scope.universityNames.push({
        id: null,
        name: name
    });
};
AdminPageCtrl.deleteUniversity = function ($scope, index) {
    $scope.universityNames.splice(index, 1);
};

AdminPageCtrl.getFacultyList = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/types/university/faculties/get').success(function (data) {
        $scope.facultyNames = data;
    });
    deferred.resolve($scope.facultyNames);
};
AdminPageCtrl.addFaculty= function ($scope,uname, name) {
    if($scope.facultyNames[uname] == null) {
        $scope.facultyNames[uname] = [];
    }
    $scope.facultyNames[uname].push({
        id: null,
        name: name
    });
};
AdminPageCtrl.deleteFaculty = function ($scope, index, uname) {
    $scope.facultyNames[uname].splice(index, 1);
};

AdminPageCtrl.sendInfo = function ($scope, $http) {
    var infoToSend ={
        technology: $scope.skillNames,
        university: $scope.universityNames,
        faculty: $scope.facultyNames
    }
    $http.post('/rest/types/everything/replace' , infoToSend)
        .error(function (data, status) {
            $(".alert").alert()
        });
};