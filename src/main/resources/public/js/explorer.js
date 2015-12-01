function showModal(title, text) {
    var modal = $('#modal');

    // Set content
    modal.find('h4.modal-title').html(title);
    modal.find('.modal-body p').html(text);

    // Show modal
    modal.modal('show');
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
        var options = {
            value: yasqe.getValue(),
            sparql: {
                endpoint: 'http://localhost:3030/' + $("#endpoint").val() + '/query',
                callbacks: {
                    beforeSend: function() {
                        console.log('before send');
                    },
                    complete: function() {
                        console.log('complete');
                    },
                    error: function() {
                        showModal('Error', 'Could not execute query!.');
                    },
                    success: function() {
                        console.log('success');
                        console.log(result);
                    }
                }
            }
        };

        yasqe.query(options);

        return false;
    });
});