
calculator = (function () {
    var datos;

    return {
        setDatos: function () {
            datos = document.getElementById("nums").value;
            
        },

        ponerDatos: function (datos) {
            console.log(datos)           
            console.log(datos.mean)
            
            let std = datos.std
            $("#resultados").find("#resultsBody").append(
                "<tr><td>" + JSON.stringify(datos.mean) + "</td><td>" + JSON.stringify(datos.std) + "</td></tr>")
        
            
            // var dataJson = JSON.parse(data);
            
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

        

        $.ajax({
            url: url,
            data: datas,
            type: 'POST',
            //dataType: 'json',
            contentType: 'application/json',
            
            success: function(data){
                console.log(data)
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