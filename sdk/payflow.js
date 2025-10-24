function loadPayflowWidget(config) {

  const container = document.getElementById(config.containerId);

  container.innerHTML = `
    <form id="payflow-form">
      <input type="text" placeholder="Name" id="name" required><br>
      <input type="email" placeholder="Email" id="email" required><br>
      <input type="text" placeholder="Card Number" id="card" required><br>
      <input type="text" placeholder="MM/YY" id="expiry" required><br>
      <input type="text" placeholder="CVV" id="cvv" required><br>
      <input type="text" placeholder="Country" id="country" required><br>
      <input type="text" placeholder="Postcode" id="postcode" required><br>
      <button type="submit">Pay $${config.amount}</button>
    </form>
  `;

  document.getElementById("payflow-form").addEventListener("submit", async (e) => {
    e.preventDefault();
    const body = {
      customerName: document.getElementById("name").value,
      customerEmail: document.getElementById("email").value,
      cardNumber: document.getElementById("card").value,
      cardExpiryDate: document.getElementById("expiry").value,
      cardCVV: document.getElementById("cvv").value,
      merchantId: config.merchantId,
      // unused variables as of now
      country: document.getElementById("country").value,
      postcode: document.getElementById("postcode").value,
      amount: config.amount
    };
    const res = await fetch(`${config.apiBase}/api/checkout/process`, {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(body) 
    });
    const result = await res.json();
    alert(`Payment ${result.status}! Transaction ID: ${result.id}`);
  });
}
