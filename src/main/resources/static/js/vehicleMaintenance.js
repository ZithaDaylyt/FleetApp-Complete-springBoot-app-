
$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(vehicleMaintenance, status){
           $('#idEdit').val(vehicleMaintenance.id);
           			$('#priceEdit').val(vehicleMaintenance.price);
           			$('#remarksEdit').val(vehicleMaintenance.remarks);
           			$('#ddlSupplierEdit').val(vehicleMaintenance.supplierid);
           			$('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid);

           			//Create a date variable and extract only the date part of the fiedl
           			var startDate = vehicleMaintenance.startDate.substr(0,10);
           			var endDate = vehicleMaintenance.endDate.substr(0,10);

           			$('#startDateEdit').val(startDate);
           			$('#endDateEdit').val(endDate);
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