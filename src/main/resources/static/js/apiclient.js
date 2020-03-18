apiclient = (function() {

    return {
        getAirportsByName: function(name) {
            var getPromise=$.ajax({
                dataType: "json",
                url: "/airports/"+name,
            });
            return getPromise;
        }
    };
})();