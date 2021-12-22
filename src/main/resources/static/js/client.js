
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(client, status){
            $('#txtAddressEdit').val(client.address);
            $('#txtCityEdit').val(client.city);
            $('#ddlCountryEdit').val(client.countryid);
            $('#txtDetails').val(client.details);
            $('#txtIdEdit').val(client.id);
            $('#txtEmailEdit').val(client.email);
            $('#txtNameEdit').val(client.name);
            $('#txtPhoneEdit').val(client.phone);
            $('#ddlStateEdit').val(client.stateid);
            $('#txtWebsiteEdit').val(client.website);
        });
        $('#editModal').modal();
    });

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $('#delRef').attr('href', href);

        $('#deleteModal').modal();
    });

});
console.log("Yo!")