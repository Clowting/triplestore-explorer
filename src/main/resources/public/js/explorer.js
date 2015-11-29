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
                    success: function(result) {
                        showModal('Remove success', 'Succesfully removed dataset <code>' + datastore_id + '</code>.');
                        button.closest('tr').remove();
                    },
                    error: function(result) {
                        showModal('Remove failed', 'Failed to removed dataset <code>' + datastore_id + '</code>!');
                    }
                });
            }
        }
    });
});