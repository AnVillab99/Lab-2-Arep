
calculator = (function () {
    var datos;

    return {
        setDatos: function () {
            datos = document.getElementById("nums").value;
            
        },

        ponerDatos: function (datos) {
            $("#mean").empty();
            $("#std").empty();
            var mean = "mean: " +datos.mean;
            var std = "std:"+datos.std;
            $("#mean").append(mean);
            $("#std").append(std);

            var table = document.getElementById("nums");
            var aMeter  ;
            document.getElementById("nums").append
        },

        obtenerDatos: function () {           
            calculator.setDatos();
            calculadora.getResultadosR('/calculator/calcular/',datos, calculator.ponerDatos);
            
        }
    };  
})();
calculadora = (function () {

    
    return {      
        getResultadosR: function (url,datas, callback) {

        console.log("pre "+datas);
        console.log("pre "+JSON.stringify(datas));

        $.ajax({
            url: url,
            data: datas,
            type: 'POST',
            dataType: 'json',
            //contentType: 'application/json',
            
            success: function(data){
                callback(data);
            },
            error: function(data){
                console.log("error: "+JSON.stringify(datas));
            },
            
        });
/*
        
        $.get( '/calculator/calcular', function( data ) {
        console.log(data);
        
        callback(data);
        
        });*/
        }
    };

})();