Vue.use(VueMaterial.default);

new Vue({
    el: '#app',
    data: {
        tags: []
    },
    methods: {

    },
    created: function () {
        var vueInstance = this;
        axios.get('/tags-rest/all')
            .then(function (response) {
                vueInstance.tags = response.data;
                console.log(vueInstance.tags);
            });
    }
});