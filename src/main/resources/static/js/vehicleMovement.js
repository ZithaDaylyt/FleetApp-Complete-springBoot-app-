
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(vehicleMovement, status){
         $('#idEdit').val(vehicleMovement.id);
         			$('#ddlVehicleEdit').val(vehicleMovement.vehicleid);
         			$('#ddlLocation1Edit').val(vehicleMovement.locationid1);
         			$('#ddlLocation2Edit').val(vehicleMovement.locationid2);

         			var date1 = vehicleMovement.date1.substr(0,10);
         			var date2 = vehicleMovement.date2.substr(0,10);
         			$('#date1Edit').val(date1);
         			$('#date2Edit').val(date2);
         			$('#remarksEdit').val(vehicleMovement.remarks);
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