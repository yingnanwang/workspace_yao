$(function(){
    $('#nav li').click(function() {
        $(this).addClass('current').siblings().removeClass('current');
    });
    $('.up').click(function() {
        if ($(this).hasClass('fa-thumbs-up')) {
        	$(this).removeClass('fa-thumbs-up').addClass('fa-thumbs-o-up');
            x = parseInt($(this).next().html()) - 1;
            $(this).next().html(x);
        } else {
            $(this).removeClass('fa-thumbs-o-up').addClass('fa-thumbs-up');
            x = parseInt($(this).next().html()) + 1;
            $(this).next().html(x);        }
    });
    $('.right').click(function() {
		x = parseInt($('.img-roll').css('left'));
        if (x == -800) {
            x = 0;
        } else {
            x = x -400;
        }
        $('.img-roll').css('left', x + 'px');
    });
    $('.left').click(function() {
		x = parseInt($('.img-roll').css('left'));
        if (x == 0) {
            x = -800;
        } else {
            x = x + 400;
        }
        $('.img-roll').css('left', x + 'px');
    });
});