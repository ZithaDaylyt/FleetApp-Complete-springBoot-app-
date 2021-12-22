
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(state, status){
          $('#idEdit').val(state.id);
          			$('#ddlCountryEdit').val(state.countryid);
          			$('#capitalEdit').val(state.capipal);
          			$('#codeEdit').val(state.code);
          			$('#nameEdit').val(state.name);
          			$('#detailsEdit').val(state.details);
        });
        $('#editModal').modal();
    });
//
//    $('table #detailsButton').on('click',function(event){
//        event.preventDefault();
//        var href = $(this).attr('href');
//        $.get(href, function(state,status){
//            $('#idDetails').val(state.id);
//            $('#nameDetails').val(state.name);
//            $('#detailsDetails').val(state.details);
//        });
//
//        $('#detailModal').modal();
//    })

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $('#delRef').attr('href', href);

        $('#deleteModal').modal();
    });

});