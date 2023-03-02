var Dropdown = (function() {

    return {
        
        buildDropdown : function (currentStage) {
            var stages = ['Stage 1', 'Stage 2', 'Stage 3', 'Stage 4', 'Stage 5', 'Stage 6'];

            var stringHTML = '';

            stringHTML += '<button onclick="Dropdown.clickDropdown()" class="dropbtn">' + currentStage + '</button><div id="myDropdown" class="dropdown-content">';

            for (var i = 0; i < stages.length; i++) {
                if (stages[i] !== currentStage) {
                    stringHTML += '<a onclick="Dropdown.selectStage(\'' + stages[i] + '\')" >' + stages[i] + '</a>';
                } else {
                    stringHTML += '<a id="selectedStage">' + stages[i] + '</a>';
                };
            };
            stringHTML += '</div>';

            document.getElementById("dropdown").innerHTML = stringHTML;
        },

       selectStage : function (stage) {
            Dropdown.buildDropdown(stage);
            Schedule.buildSchedule(stage);
        },
        
        clickDropdown : function () {
            document.getElementById("myDropdown").classList.toggle("show");
        }
        
    };
    
}());