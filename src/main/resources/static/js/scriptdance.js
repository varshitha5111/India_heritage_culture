const data = {
  "Yakshagana": {
      description: `
          <h3>Yakshagana</h3>
          <p>Yakshagana is a traditional theatre form combining dance, music, and dialogue. It has its roots in Karnataka's coastal regions and is known for narrating stories from Hindu epics like the Mahabharata and Ramayana. Historically, it evolved as a temple art in the 16th century and is associated with the Bhakti movement, spreading religious and moral teachings.</p>
      `,
      music: `
          <h3>Yakshagana Music</h3>
          <p>Yakshagana's music involves a mix of traditional instruments like Maddale (a percussion instrument) and Chande drums. Singers narrate the story in a high-pitched, dramatic style, accompanied by background scores.</p>
      `,
      danceForms: `
          <h3>Popular Yakshagana Dance Forms</h3>
          <div class="dance-images">
              <img src="https://blr1.digitaloceanspaces.com/newskarnataka.com/wp-content/uploads/2024/09/150920241010.webp" class="dance-img">
              <img src="https://cdn.vvimgs.com/wp-content/uploads/2023/07/Yakshagana.jpg" class="dance-img">
              <img src="https://content.jdmagicbox.com/v2/comp/bangalore/n4/080pxx80.xx80.170208101507.l2n4/catalogue/karnataka-mahila-yakshagana-jp-nagar-7th-phase-bangalore-dance-classes-xrkcpzia5u.jpg" alt="Yakshagana Dance 3" class="dance-img">
          </div>
      `
  },
  "Dollu Kunitha": {
      description: `
          <h3>Dollu Kunitha</h3>
          <p>Dollu Kunitha is a vigorous drum-based dance performed by men in synchronized formations. It is dedicated to Lord Beereshwara (Shiva) and originated in temples to celebrate religious events. Historically, it served as both a spiritual ritual and a performance to inspire devotion and discipline.</p>
      `,
      music: `
          <h3>Dollu Kunitha Music</h3>
          <p>The music of Dollu Kunitha is centered around large drums, producing rhythmic beats. The synchronized drumming and chanting create an energetic atmosphere, symbolizing unity and strength.</p>
      `,
      danceForms: `
          <h3>Popular Dollu Kunitha Dance Forms</h3>
          <div class="dance-images">
              <img src="https://www.amarchitrakatha.com/wp-content/uploads/2023/05/Dollu-Kunitha-short_thumbnail.jpg" alt="Dollu Kunitha Dance 1" class="dance-img">
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaXRD0Y8OKZ-qveCzabX2DyWtWVFjVgdYgZMx7R1ltiTwB0CEPSGFTUMvaOv3aMCilD3c&usqp=CAU" alt="Dollu Kunitha Dance 2" class="dance-img">
          </div>
      `
  },
  "Veeragase": {
      description: `
          <h3>Veeragase</h3>
          <p>Veeragase is a dance rooted in the Veerashaiva tradition and symbolizes bravery and devotion to Lord Shiva. Performed during religious festivals and processions, it narrates tales of valor from Hindu mythology. Historically, it represented the warrior spirit of Karnataka's communities.</p>
      `,
      music: `
          <h3>Veeragase Music</h3>
          <p>Veeragase music is characterized by rhythmic drumming, cymbals, and chanting. The intense beats emphasize the dance's powerful and heroic themes.</p>
      `,
      danceForms: `
          <h3>Popular Veeragase Dance Forms</h3>
          <div class="dance-images">
              <img src="https://live.staticflickr.com/3864/15113996411_e89f56052b_b.jpg" alt="Veeragase Dance 1" class="dance-img">
              <img src="https://i.pinimg.com/736x/8e/c9/48/8ec9484bfc81bf2f81c0f1b0e6c4c034.jpg" alt="Veeragase Dance 2" class="dance-img">
          </div>
      `
  },
  "Kamsale": {
      description: `
          <h3>Kamsale</h3>
          <p>Kamsale is a devotional dance form performed by devotees of Lord Mahadeshwara. It involves the use of cymbals (Kamsale) and is accompanied by dynamic movements. This dance has religious significance and is deeply tied to the Mahadeshwara temple rituals.</p>
      `,
      music: `
          <h3>Kamsale Music</h3>
          <p>Kamsale's music revolves around rhythmic clashing of cymbals, complemented by folk songs. The beats and songs narrate the lore of Lord Mahadeshwara, creating a divine ambiance.</p>
      `,
      danceForms: `
          <h3>Popular Kamsale Dance Forms</h3>
          <div class="dance-images">
              <img src="https://th-i.thgim.com/public/entertainment/dance/serg1q/article33402699.ece/alternates/FREE_1200/11-Kamsale" alt="Kamsale Dance 1" class="dance-img">
              <img src="https://cdn.kstdc.co/uploads/2021/08/kamsale.jpg" alt="Kamsale Dance 2" class="dance-img">
          </div>
      `
  }
};
function showDetails(dance, type) {
  const content = data[dance]?.[type] || "<p>Details not available.</p>";
  document.getElementById('modalBody').innerHTML = content;
}
