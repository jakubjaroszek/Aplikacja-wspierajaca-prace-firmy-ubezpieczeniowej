

for (var i = min; i<=max; i++){
var opt = document.createElement('option');
opt.value = i;
opt.innerHTML = i;
select.appendChild(opt);
}


$( function() {
    $( "#datepicker" ).datepicker();
  } );

for (var i = min; i<=max; i++){
var opt = document.createElement('option');
opt.value = i;
opt.innerHTML = i;
select.appendChild(opt);
}

