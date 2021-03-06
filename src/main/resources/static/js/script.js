function limpiarErrores(){
    var error = document.getElementsByTagName('span');
    for(var i=0; i<error.length; i++){
        error[i].innerText="";
    }
}
var correo = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
var patronNumeros = /[0-9]/;

/*---------------------------------------
            Login
----------------------------------------*/
function validarLogin(form){
    limpiarErrores();
    // validar campios vacios
    if(form.usuario.value.trim().length==0){
        document.getElementById('errorUser').innerText='* Campo obligatorio';
        form.usuario.focus();
        return false;
    }else if(!correo.test(form.usuario.value)){
        document.getElementById('errorUser').innerText="* Email no valido";
        formulario.email.focus;
        return false;
    }
    if(form.contrasena.value.trim().length == 0){
        document.getElementById('errorPass').innerText='* Campo obligatorio';
        formulario.contrasena.focus();
        return false;
    }
}
jQuery(document).on("submit", "#login", function(event){
    event.preventDefault();
    let user = $($("#login")[0].usuario).val();
    let pass =$($("#login")[0].contrasena).val();
    console.log(user);
    console.log(pass);
    $.ajax({
        url:"http://129.151.114.181:8080/api/user/"+user+"/"+pass,
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            if(!respuesta.error){
                if(respuesta.name!="NO DEFINIDO"){
                    console.log("entro")
                    location.href='privado.html';
                }else{
                    $(".error").html("<span>No exite el usuario</span>").slideDown('slow');
                    setTimeout(function(){
                        $(".error").slideUp("slow");
                    },3000)
                }
            }
        }
    })
})

/*---------------------------------------
            Registro
----------------------------------------*/
function validarNewUser(form){
    limpiarErrores();
    //validar nombre
    if(form.nombre.value.trim().length==0){
        document.getElementById('errorNombre').innerText="* Campo Obligatorio";
        form.nombre.focus();
        return false
    }else if(patronNumeros.test(form.nombre.value)){
        document.getElementById("errorNombre").innerText="* El nombre no puede contener n??meros"
        return false;
    }

    //validar email
    if(!correo.test(form.emailN.value)){
        document.getElementById('myEmail').innerText="* Email no valido";
        form.emailN.focus;
        return false;
    }else if(form.emailN.value.trim().length==0){
        document.getElementById('myEmail').innerText="* Campo obligatorio";
        form.emailN.focus;
        return false;
    }
    $("#registro").on("blur", "#emailN", function () {
        console.log("Ingreso")
        console.log($(this).val())
        $.ajax({
            url:"http://129.151.114.181:8080/api/user/"+$(this).val(),
            type: "GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                if(respuesta){
                    document.getElementById('myEmail').innerText="* El Email ya esta registrado";
                    form.email.focus;
                    return false;
                }
            }
        })
    })

    //validar password
    if(form.newpass.value.trim().length == 0){
        document.getElementById('mypass').innerText='* Campo obligatorio';
        form.newpass.focus();
        return false;
    }else if(form.newpass.value.trim().length < 7){
        document.getElementById('mypass').innerText='* Clave minimo 7 caracteres';
        form.newpass.focus();
        return false;

    }
    //confirmar password
    if(form.newpass.value != form.chekpass.value){
        document.getElementById("confirmar").innerText="* La contrase??a no coincide";
        form.chekpass.focus();
        return false;
    }
    jQuery(document).on("submit", "#registro", function(event){
        event.preventDefault();
        let info={
            email: $($("#registro")[0].emailN).val(),
            password: $($("#registro")[0].newpass).val(),
            name: $($("#registro")[0].nombre).val()
        }
        data = JSON.stringify(info);
        console.log(data);
        $.ajax({
            url:"http://129.151.114.181:8080/api/user/new",
            type:"POST",
            datatype:"JSON",
            contentType:"application/JSON; charset=utf-8",
            data:data,
            success: function(datos){
                console.log(datos);
                $(".ok").html("<span>Se creo la cuenta correctamente</span>").slideDown('slow');
                setTimeout(function(){
                    $(".ok").slideUp("slow");
                },3000)
            }
        })

    })
}