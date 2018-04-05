window.onload=init;

function init(){
	document.body.classList.add("container");
}

function navQuestion(index){
	if(index<0){
		index = 0;
	} else if(index>3){
		index=3;
	}
	
}