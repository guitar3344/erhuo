seajs.config({
    alias: {
        'jquery': 'jquery/1.7.1/jquery'
    },
//    preload: [
//        Function.prototype.bind ? '' : 'es5-safe',
//        this.JSON ? '' : 'json'
//    ],
//    debug: true,
//    map: [
//        ['http://example.com/js/app/', 'http://localhost/js/app/']
//    ],
    base: '/javascript/',
    charset: 'utf-8',
    timeout: 20000
});