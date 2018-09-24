$(function() {

    $( function() {
        var dialog, form,

            title = $( "#title" ),
            description = $( "#description" ),
            assign = $( "#assign"),
            order = $( "#order"),
            allFields = $( [] ).add( title ).add( description ).add( assign ).add( order ),
            tips = $( ".validateTips" );

        function updateTips( t ) {
            tips
                .text( t )
                .addClass( "ui-state-highlight" );
            setTimeout(function() {
                tips.removeClass( "ui-state-highlight", 1500 );
            }, 500 );
        }

        function checkLength( o, n, min, max ) {
            if ( o.val().length > max || o.val().length < min ) {
                o.addClass( "ui-state-error" );
                updateTips( "Length of " + n + " must be between " +
                    min + " and " + max + "." );
                return false;
            } else {
                return true;
            }
        }

        function addTask() {
            var valid = true;
            allFields.removeClass( "ui-state-error" );

            valid = valid && checkLength( title, "title", 3, 100 );
            valid = valid && checkLength( description, "description", 6, 250 );
            valid = valid && checkLength( order, "order", 1, 500);

            if ( valid ) {
                $( "#tasks-contain" ).append("Title: "+ title.val() + "<br/> " +
                    "Description: " + description.val() + "<br/>" + "Assignee: " + assign.val() + "<br/>" + "Task Order: " + order.val() +"<br/>");
                dialog.dialog( "close" );
            }
            return valid;
        }

        dialog = $( "#dialog-form" ).dialog({
            autoOpen: false,
            height: 400,
            width: 350,
            modal: true,
            buttons: {
                "Create a task": addTask,
                Cancel: function() {
                    dialog.dialog( "close" );
                }
            },
            close: function() {
                form[ 0 ].reset();
                allFields.removeClass( "ui-state-error" );
            }
        });

        form = dialog.find( "form" ).on( "submit", function( event ) {
            event.preventDefault();
            addTask();
        });

        $( "#create-task" ).button().on( "click", function() {
            dialog.dialog( "open" );
        });
    } );

});