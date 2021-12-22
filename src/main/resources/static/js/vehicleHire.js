
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(country, status){
         $('#idEdit').val(vehicleHire.id);
         			$('#ddlClientEdit').val(vehicleHire.clientid);

         			var dateIn = vehicleHire.dateIn.substr(0,10);
         			var dateOut = vehicleHire.dateOut.substr(0,10);
         			$('#dateInEdit').val(dateIn);
         			$('#dateOutEdit').val(dateOut);

         			$('#timeInEdit').val(vehicleHire.timeIn);
         			$('#timeOutEdit').val(vehicleHire.timeOut);

         			$('#ddlLocationEdit').val(vehicleHire.locationid);
         			$('#priceEdit').val(vehicleHire.price);
         			$('#remarksEdit').val(vehicleHire.remarks);
         			$('#ddlVehicleEdit').val(vehicleHire.vehicleid);
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