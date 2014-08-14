
var StudentInfoCtrl = studentsControllers.controller('StudentInfoCtrl', ['$scope', '$routeParams','ProjectHistoryFactory', '$q', '$http','CuratorsListFactory', function ($scope, $routeParams,ProjectHistoryFactory, $q, $http,CuratorsListFactory) {
    if ($scope.studentInfo == null) { //make feedback-list-tab active
        $scope.active = 'active';
    }
    else {
        $scope.englishLevels = StudentInfoCtrl.englishLevels;
        $scope.salaries = StudentInfoCtrl.salaries;

        $scope.states = StudentInfoCtrl.states;
        StudentInfoCtrl.getSkillSet($scope, $http, $q);
        StudentInfoCtrl.getProjectList($scope, $http, $q);
        StudentInfoCtrl.getUniversityList($scope, $http, $q);
        StudentInfoCtrl.getFacultyList($scope, $http, $q);
        $scope.sendStudentInfo = function () {
            StudentInfoCtrl.sendStudentInfo($scope, $http, $routeParams.studId);
        };
        $scope.addSkill = function () {
            StudentInfoCtrl.addSkill($scope);
        };
        $scope.deleteSkill = function (index) {
            StudentInfoCtrl.deleteSkill($scope,index);
        };
    }
    $scope.addProject = function(){
        StudentInfoCtrl.addProject($scope);
    };
    $scope.deleteProject = function(index){
        StudentInfoCtrl.deleteProject($scope,index);
    };
    $scope.deattachCurator = function(index) {
        $scope.studentInfo.curator.splice(index,1)
    };
    $scope.allCuratorsList = CuratorsListFactory.getCuratorsList();
    $scope.attachNewCurator = function(){
        $scope.studentInfo.curator.push(null);
    };
}]);
StudentInfoCtrl.englishLevels = [
    {value: "beginner", name: "Beginner"},
    {value: "elementary", name: "Elementary"},
    {value: "preintermediate", name: "Pre-Intermediate"},
    {value: "intermediate", name: "Intermediate"},
    {value: "upperintermediate", name: "Upper-Intermediate"},
    {value: "advanced", name: "Advanced"}
];
StudentInfoCtrl.getSkillSet = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/types/technology/get').success(function (data) {
        $scope.skillTypes = data;
    });
    deferred.resolve($scope.skillTypes);
};

StudentInfoCtrl.sendStudentInfo = function ($scope, $http, id) {
    $http.post('/rest/stud/' + id + '/edit', $scope.studentInfo)
        .error(function (data, status) {
            alert('Error: ' + status);
        });
};
StudentInfoCtrl.addSkill = function ($scope) {
    $scope.studentInfo.skillSet.push({
        id: null,
        level: null
    });
};
StudentInfoCtrl.deleteSkill = function ($scope, index) {
    $scope.studentInfo.skillSet.splice(index, 1);
};
StudentInfoCtrl.salaries = [
    {name: 'Billable', value: true},
    {name: 'Not billable', value: false}
];
StudentInfoCtrl.states = [
    {name: 'Work', value: 'WORK'},
    {name: 'Practise', value: 'PRACTICE'},

];

StudentInfoCtrl.getProjectList = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/proj/all').success(function (data) {
        $scope.projectNames = data;
    });
    deferred.resolve($scope.projectNames);

};
StudentInfoCtrl.addProject = function ($scope) {
    $scope.studentInfo.currentProjects.push(null);
};
StudentInfoCtrl.deleteProject = function ($scope, index) {
    $scope.studentInfo.currentProjects.splice(index, 1);
};

StudentInfoCtrl.getUniversityList = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/types/university/get').success(function (data) {
        $scope.universityNames = data;
    });
    deferred.resolve($scope.universityNames);

};
StudentInfoCtrl.getFacultyList = function ($scope, $http, $q) {
    var deferred = $q.defer();
    $http.get('/rest/types/university/faculties/get').success(function (data) {
        $scope.facultyNames = data;
    });
    deferred.resolve($scope.facultyNames);

};


