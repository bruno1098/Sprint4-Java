document.addEventListener("DOMContentLoaded", function() {
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Ruim', 'Bom', 'Medio'],
            datasets: [{
                label: 'Feedbacks',
                data: [0, 0, 0],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    function fetchDataAndUpdateChart() {
        fetch('/api/charts/data')
            .then(response => response.json())
            .then(data => {
                myChart.data.datasets[0].data = data;
                myChart.update();
            });
    }

    setInterval(fetchDataAndUpdateChart, 7000);
});
