var refreshIntervalId = null;

function cleanMessage() {
    $('#message').html('');
}

function displayMessage(message) {
    $('#message').html('<div class="alert alert-warning">'+ message + '</div>');
}

function updateBerlinClockSection(data, section) {
    if(Array.isArray(data[section])) {
        var sectionSelector = $('#' + section);
        data[section].forEach(function(element, index){
            if(element) {
                $('.id__' + index, sectionSelector).addClass('clock_enabled');
                $('.id__' + index, sectionSelector).removeClass('clock_disabled');
            }
            else{
                $('.id__' + index, sectionSelector).addClass('clock_disabled');
                $('.id__' + index, sectionSelector).removeClass('clock_enabled');
            }
        });
    }
    else {
        if(data[section]){
            $('#' + section).addClass('clock_enabled');
            $('#' + section).removeClass('clock_disabled');
        }
        else {
            $('#' + section).addClass('clock_disabled');
            $('#' + section).removeClass('clock_enabled');
        }
    }
}

function updateBerlinClock(data) {
    updateBerlinClockSection(data, 'clockTwoSeconds');
    updateBerlinClockSection(data, 'hoursPerFive');
    updateBerlinClockSection(data, 'hoursPerOne');
    updateBerlinClockSection(data, 'minutesPerFive');
    updateBerlinClockSection(data, 'minutesPerOne');
}

function getBerlinTimeRepresentation() {
    cleanMessage();

    $.ajax({
          method: "GET",
          url: "/api/clock/berlin",
          dataType: "json",
          data: {}
    }).done(function( data ) {
          updateBerlinClock(data);
    }).fail(function( jqXHR, textStatus ) {
          displayMessage('Error executing the request to get the berlin time representation');

          if(refreshIntervalId != null) {
            window.clearInterval(refreshIntervalId);
            refreshIntervalId = null;
          }
    });
}

(function() {
    refreshIntervalId = window.setInterval(getBerlinTimeRepresentation, 1500);
})();