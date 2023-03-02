(function () {
    Schedule.buildSchedule('Stage 1');
    Dropdown.buildDropdown('Stage 1');

    window.onclick = function (event) {
        if (!event.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            for (var i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
                ;
            }
            ;
        }
        ;
    };
}());