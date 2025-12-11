<script>
    // Section Switching
    function showSection(id) {
        document.querySelectorAll('.page-section').forEach(section => section.classList.remove('active'));
        document.getElementById(id).classList.add('active');
        window.scrollTo(0,0);
    }

    // Patient Functions
    function loginPatient() {
        const email = document.getElementById('patient-email').value;
        const password = document.getElementById('patient-password').value;

        // TODO: Connect backend authentication here
        if(email && password) {
            alert("Patient logged in successfully!");
            showSection('patient-dashboard');
        } else {
            alert("Please enter valid email and password.");
        }
    }

    function registerPatient() {
        const name = document.getElementById('patient-name').value;
        const email = document.getElementById('patient-email-reg').value;
        const password = document.getElementById('patient-password-reg').value;

        // TODO: Connect backend registration here
        if(name && email && password) {
            alert("Patient registered successfully!");
            showSection('patient-login');
        } else {
            alert("Please fill all fields.");
        }
    }

    // Doctor Functions
    function loginDoctor() {
        const email = document.getElementById('doctor-email').value;
        const password = document.getElementById('doctor-password').value;

        // TODO: Connect backend authentication here
        if(email && password) {
            alert("Doctor logged in successfully!");
            showSection('doctor-dashboard');
        } else {
            alert("Please enter valid email and password.");
        }
    }
</script>
