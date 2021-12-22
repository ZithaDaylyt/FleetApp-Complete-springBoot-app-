
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(country, status){
                $('#idEdit').val(country.id);
           		$('#descriptionEdit').val(country.description);
           		$('#codeEdit').val(country.code);

        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(country,status){
            $('#idDetails').val(country.id);
            $('#descriptionDetails').val(country.description);
            $('#codeDetails').val(country.code);
            $('#lastModifiedByDetails').val(country.lastModifiedBy);
            $('#lastModifiedDetails').val(country.lastModifiedDate.substr(0,19).replace("T",""));
        });
        $('#detailsModal').modal();
    });

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $('#delRef').attr('href', href);

        $('#deleteModal').modal();
    });

});
console.log("Yo!")