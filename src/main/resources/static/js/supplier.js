
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href = (this).attr('href');
        $.get(href, function(supplier, status){
            $('#txtAddressEdit').val(supplier.address);
            $('#txtCityEdit').val(supplier.city);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#txtDetails').val(supplier.details);
            $('#txtEmailEdit').val(supplier.email);
            $('#txtNameEdit').val(supplier.name);
            $('#txtPhoneEdit').val(supplier.phone);
            $('#ddlStateEdit').val(supplier.stateid);
            $('#txtWebsiteEdit').val(supplier.website);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(country,status){
            ///
        })
    })

    $('table #deleteButton').on('click', function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $('#delRef').attr('href', href);

        $('#deleteModal').modal();
    });

});
console.log("Yo!")