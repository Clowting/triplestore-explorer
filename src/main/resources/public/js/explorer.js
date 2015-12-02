function showModal(title, text) {
    var modal = $('#modal');

    // Set content
    modal.find('h4.modal-title').html(title);
    modal.find('.modal-body p').html(text);

    // Show modal
    modal.modal('show');
}

function showQueryResult(results) {
    var parsed_results;

    // Clear old results
    $('#results tbody').html('');

    if(parsed_results = jQuery.parseJSON(results)) {
        $.each(parsed_results.results.bindings, function(key, result) {
            var subject = result.subject;
            var predicate = result.predicate;
            var object = result.object;

            // Make row
            var row = '<tr>';

            // Subject
            if(subject['type'] === 'uri') {
                row += '<td><a href="' + subject.value + '">' + subject.value + '</a></td>';
            }
            else {
                row += '<td>' + subject.value + '</td>';
            }

            // Predicate
            if(predicate['type'] === 'uri') {
                row += '<td><a href="' + predicate.value + '">' + predicate.value + '</a></td>';
            }
            else {
                row += '<td>' + predicate.value + '</td>';
            }

            // Object
            if(object['type'] === 'uri') {
                row += '<td><a href="' + object.value + '">' + object.value + '</a></td>';
            }
            else {
                row += '<td>' + object.value + '</td>';
            }

            // Close row
            row +='</tr>';

            // Append row to table
            $('#results tbody').append(row);
        });
    }
}

$(document).ready(function() {
    $('.action').click(function() {
        var button = $(this);
        var datastore_id = button.attr('data-ds-id');

        if(datastore_id !== "") {
            // Actions
            if(button.hasClass('remove')) {
                $.ajax({
                    url: 'http://localhost:4567/datasets/remove' + datastore_id,
                    success: function() {
                        showModal('Remove success', 'Succesfully removed dataset <code>' + datastore_id + '</code>.');
                        button.closest('tr').remove();
                    },
                    error: function() {
                        showModal('Remove failed', 'Failed to removed dataset <code>' + datastore_id + '</code>!');
                    }
                });
            }
        }
    });

    // SPARQL editor
    var yasqe = YASQE.fromTextArea(document.getElementById('query'));

    $("#run-query").click(function() {
        yasqe.options = {
            sparql: {
                endpoint: 'http://localhost:4567/query/execute/query/' + $("#endpoint").val(),
                callbacks: {
                    error: function() {
                        showModal('Error', 'Could not execute query!');
                    },
                    success: function(result) {
                        showQueryResult(result);
                    }
                },
                queryName: 'query'
            }
        };

        yasqe.query();

        return false;
    });
});