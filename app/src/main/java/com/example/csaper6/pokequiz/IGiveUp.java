package com.example.csaper6.pokequiz;//package com.example.csaper6.pokequiz;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class IGiveUp extends AppCompatActivity {
    ImageView pokeSprite;
    ImageView hidenSprite;
    TextView scoreText;
    TextView questionText;
    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    private JSONObject a;
    private int randomMon;
    private int answerSetupType;
    private String fullUrl;
    private String fullSpriteUrl;
    private String pNam;
    private String url;
    private String spriteUrl;
    public Question question;
    Pokemon pokemon;
    private int score;
    ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokeSprite = (ImageView) findViewById(R.id.pokeSprite);
        pokeSprite.setScaleX(2);
        pokeSprite.setScaleY(2);
        hidenSprite = (ImageView) findViewById(R.id.hiddenSprite);
        hidenSprite.setScaleX(2);
        hidenSprite.setScaleY(2);


        scoreText = (TextView) (findViewById(R.id.scoreText));
        questionText = (TextView) (findViewById(R.id.questionText));

        answer1 = (Button) (findViewById(R.id.answer1));
        answer2 = (Button) (findViewById(R.id.answer2));
        answer3 = (Button) (findViewById(R.id.answer3));
        answer4 = (Button) (findViewById(R.id.answer4));

        question = new Question();

        names = new ArrayList<>();
        //region alllllllll the mons
        names.add("Bulbasaur");
        names.add("Ivysaur");
        names.add("Venusaur");
        names.add("Charmander");
        names.add("Charmeleon");
        names.add("Charizard");
        names.add("Squirtle");
        names.add("Wartortle");
        names.add("Blastoise");
        names.add("Caterpie");
        names.add("Metapod");
        names.add("Butterfree");
        names.add("Weedle");
        names.add("Kakuna");
        names.add("Beedrill");
        names.add("Pidgey");
        names.add("Pidgeotto");
        names.add("Pidgeot");
        names.add("Rattata");
        names.add("Raticate");
        names.add("Spearow");
        names.add("Fearow");
        names.add("Ekans");
        names.add("Arbok");
        names.add("Pikachu");
        names.add("Raichu");
        names.add("Sandshrew");
        names.add("Sandslash");
        names.add("Nidoran♀");
        names.add("Nidorina");
        names.add("Nidoqueen");
        names.add("Nidoran♂");
        names.add("Nidorino");
        names.add("Nidoking");
        names.add("Clefairy");
        names.add("Clefable");
        names.add("Vulpix");
        names.add("Ninetales");
        names.add("Jigglypuff");
        names.add("Wigglytuff");
        names.add("Zubat");
        names.add("Golbat");
        names.add("Oddish");
        names.add("Gloom");
        names.add("Vileplume");
        names.add("Paras");
        names.add("Parasect");
        names.add("Venonat");
        names.add("Venomoth");
        names.add("Diglett");
        names.add("Dugtrio");
        names.add("Meowth");
        names.add("Persian");
        names.add("Psyduck");
        names.add("Golduck");
        names.add("Mankey");
        names.add("Primeape");
        names.add("Growlithe");
        names.add("Arcanine");
        names.add("Poliwag");
        names.add("Poliwhirl");
        names.add("Poliwrath");
        names.add("Abra");
        names.add("Kadabra");
        names.add("Alakazam");
        names.add("Machop");
        names.add("Machoke");
        names.add("Machamp");
        names.add("Bellsprout");
        names.add("Weepinbell");
        names.add("Victreebel");
        names.add("Tentacool");
        names.add("Tentacruel");
        names.add("Geodude");
        names.add("Graveler");
        names.add("Golem");
        names.add("Ponyta");
        names.add("Rapidash");
        names.add("Slowpoke");
        names.add("Slowbro");
        names.add("Magnemite");
        names.add("Magneton");
        names.add("Farfetch’d");
        names.add("Doduo");
        names.add("Dodrio");
        names.add("Seel");
        names.add("Dewgong");
        names.add("Grimer");
        names.add("Muk");
        names.add("Shellder");
        names.add("Cloyster");
        names.add("Gastly");
        names.add("Haunter");
        names.add("Gengar");
        names.add("Onix");
        names.add("Drowzee");
        names.add("Hypno");
        names.add("Krabby");
        names.add("Kingler");
        names.add("Voltorb");
        names.add("Electrode");
        names.add("Exeggcute");
        names.add("Exeggutor");
        names.add("Cubone");
        names.add("Marowak");
        names.add("Hitmonlee");
        names.add("Hitmonchan");
        names.add("Lickitung");
        names.add("Koffing");
        names.add("Weezing");
        names.add("Rhyhorn");
        names.add("Rhydon");
        names.add("Chansey");
        names.add("Tangela");
        names.add("Kangaskhan");
        names.add("Horsea");
        names.add("Seadra");
        names.add("Goldeen");
        names.add("Seaking");
        names.add("Staryu");
        names.add("Starmie");
        names.add("Mr. Mime");
        names.add("Scyther");
        names.add("Jynx");
        names.add("Electabuzz");
        names.add("Magmar");
        names.add("Pinsir");
        names.add("Tauros");
        names.add("Magikarp");
        names.add("Gyarados");
        names.add("Lapras");
        names.add("Ditto");
        names.add("Eevee");
        names.add("Vaporeon");
        names.add("Jolteon");
        names.add("Flareon");
        names.add("Porygon");
        names.add("Omanyte");
        names.add("Omastar");
        names.add("Kabuto");
        names.add("Kabutops");
        names.add("Aerodactyl");
        names.add("Snorlax");
        names.add("Articuno");
        names.add("Zapdos");
        names.add("Moltres");
        names.add("Dratini");
        names.add("Dragonair");
        names.add("Dragonite");
        names.add("Mewtwo");
        names.add("Mew");
        names.add("Chikorita");
        names.add("Bayleef");
        names.add("Meganium");
        names.add("Cyndaquil");
        names.add("Quilava");
        names.add("Typhlosion");
        names.add("Totodile");
        names.add("Croconaw");
        names.add("Feraligatr");
        names.add("Sentret");
        names.add("Furret");
        names.add("Hoothoot");
        names.add("Noctowl");
        names.add("Ledyba");
        names.add("Ledian");
        names.add("Spinarak");
        names.add("Ariados");
        names.add("Crobat");
        names.add("Chinchou");
        names.add("Lanturn");
        names.add("Pichu");
        names.add("Cleffa");
        names.add("Igglybuff");
        names.add("Togepi");
        names.add("Togetic");
        names.add("Natu");
        names.add("Xatu");
        names.add("Mareep");
        names.add("Flaaffy");
        names.add("Ampharos");
        names.add("Bellossom");
        names.add("Marill");
        names.add("Azumarill");
        names.add("Sudowoodo");
        names.add("Politoed");
        names.add("Hoppip");
        names.add("Skiploom");
        names.add("Jumpluff");
        names.add("Aipom");
        names.add("Sunkern");
        names.add("Sunflora");
        names.add("Yanma");
        names.add("Wooper");
        names.add("Quagsire");
        names.add("Espeon");
        names.add("Umbreon");
        names.add("Murkrow");
        names.add("Slowking");
        names.add("Misdreavus");
        names.add("Unown");
        names.add("Wobbuffet");
        names.add("Girafarig");
        names.add("Pineco");
        names.add("Forretress");
        names.add("Dunsparce");
        names.add("Gligar");
        names.add("Steelix");
        names.add("Snubbull");
        names.add("Granbull");
        names.add("Qwilfish");
        names.add("Scizor");
        names.add("Shuckle");
        names.add("Heracross");
        names.add("Sneasel");
        names.add("Teddiursa");
        names.add("Ursaring");
        names.add("Slugma");
        names.add("Magcargo");
        names.add("Swinub");
        names.add("Piloswine");
        names.add("Corsola");
        names.add("Remoraid");
        names.add("Octillery");
        names.add("Delibird");
        names.add("Mantine");
        names.add("Skarmory");
        names.add("Houndour");
        names.add("Houndoom");
        names.add("Kingdra");
        names.add("Phanpy");
        names.add("Donphan");
        names.add("Porygon2");
        names.add("Stantler");
        names.add("Smeargle");
        names.add("Tyrogue");
        names.add("Hitmontop");
        names.add("Smoochum");
        names.add("Elekid");
        names.add("Magby");
        names.add("Miltank");
        names.add("Blissey");
        names.add("Raikou");
        names.add("Entei");
        names.add("Suicune");
        names.add("Larvitar");
        names.add("Pupitar");
        names.add("Tyranitar");
        names.add("Lugia");
        names.add("Ho-Oh");
        names.add("Celebi");
        names.add("Treecko");
        names.add("Grovyle");
        names.add("Sceptile");
        names.add("Torchic");
        names.add("Combusken");
        names.add("Blaziken");
        names.add("Mudkip");
        names.add("Marshtomp");
        names.add("Swampert");
        names.add("Poochyena");
        names.add("Mightyena");
        names.add("Zigzagoon");
        names.add("Linoone");
        names.add("Wurmple");
        names.add("Silcoon");
        names.add("Beautifly");
        names.add("Cascoon");
        names.add("Dustox");
        names.add("Lotad");
        names.add("Lombre");
        names.add("Ludicolo");
        names.add("Seedot");
        names.add("Nuzleaf");
        names.add("Shiftry");
        names.add("Taillow");
        names.add("Swellow");
        names.add("Wingull");
        names.add("Pelipper");
        names.add("Ralts");
        names.add("Kirlia");
        names.add("Gardevoir");
        names.add("Surskit");
        names.add("Masquerain");
        names.add("Shroomish");
        names.add("Breloom");
        names.add("Slakoth");
        names.add("Vigoroth");
        names.add("Slaking");
        names.add("Nincada");
        names.add("Ninjask");
        names.add("Shedinja");
        names.add("Whismur");
        names.add("Loudred");
        names.add("Exploud");
        names.add("Makuhita");
        names.add("Hariyama");
        names.add("Azurill");
        names.add("Nosepass");
        names.add("Skitty");
        names.add("Delcatty");
        names.add("Sableye");
        names.add("Mawile");
        names.add("Aron");
        names.add("Lairon");
        names.add("Aggron");
        names.add("Meditite");
        names.add("Medicham");
        names.add("Electrike");
        names.add("Manectric");
        names.add("Plusle");
        names.add("Minun");
        names.add("Volbeat");
        names.add("Illumise");
        names.add("Roselia");
        names.add("Gulpin");
        names.add("Swalot");
        names.add("Carvanha");
        names.add("Sharpedo");
        names.add("Wailmer");
        names.add("Wailord");
        names.add("Numel");
        names.add("Camerupt");
        names.add("Torkoal");
        names.add("Spoink");
        names.add("Grumpig");
        names.add("Spinda");
        names.add("Trapinch");
        names.add("Vibrava");
        names.add("Flygon");
        names.add("Cacnea");
        names.add("Cacturne");
        names.add("Swablu");
        names.add("Altaria");
        names.add("Zangoose");
        names.add("Seviper");
        names.add("Lunatone");
        names.add("Solrock");
        names.add("Barboach");
        names.add("Whiscash");
        names.add("Corphish");
        names.add("Crawdaunt");
        names.add("Baltoy");
        names.add("Claydol");
        names.add("Lileep");
        names.add("Cradily");
        names.add("Anorith");
        names.add("Armaldo");
        names.add("Feebas");
        names.add("Milotic");
        names.add("Castform");
        names.add("Kecleon");
        names.add("Shuppet");
        names.add("Banette");
        names.add("Duskull");
        names.add("Dusclops");
        names.add("Tropius");
        names.add("Chimecho");
        names.add("Absol");
        names.add("Wynaut");
        names.add("Snorunt");
        names.add("Glalie");
        names.add("Spheal");
        names.add("Sealeo");
        names.add("Walrein");
        names.add("Clamperl");
        names.add("Huntail");
        names.add("Gorebyss");
        names.add("Relicanth");
        names.add("Luvdisc");
        names.add("Bagon");
        names.add("Shelgon");
        names.add("Salamence");
        names.add("Beldum");
        names.add("Metang");
        names.add("Metagross");
        names.add("Regirock");
        names.add("Regice");
        names.add("Registeel");
        names.add("Latias");
        names.add("Latios");
        names.add("Kyogre");
        names.add("Groudon");
        names.add("Rayquaza");
        names.add("Jirachi");
        names.add("Deoxys");
        names.add("Turtwig");
        names.add("Grotle");
        names.add("Torterra");
        names.add("Chimchar");
        names.add("Monferno");
        names.add("Infernape");
        names.add("Piplup");
        names.add("Prinplup");
        names.add("Empoleon");
        names.add("Starly");
        names.add("Staravia");
        names.add("Staraptor");
        names.add("Bidoof");
        names.add("Bibarel");
        names.add("Kricketot");
        names.add("Kricketune");
        names.add("Shinx");
        names.add("Luxio");
        names.add("Luxray");
        names.add("Budew");
        names.add("Roserade");
        names.add("Cranidos");
        names.add("Rampardos");
        names.add("Shieldon");
        names.add("Bastiodon");
        names.add("Burmy");
        names.add("Wormadam");
        names.add("Mothim");
        names.add("Combee");
        names.add("Vespiquen");
        names.add("Pachirisu");
        names.add("Buizel");
        names.add("Floatzel");
        names.add("Cherubi");
        names.add("Cherrim");
        names.add("Shellos");
        names.add("Gastrodon");
        names.add("Ambipom");
        names.add("Drifloon");
        names.add("Drifblim");
        names.add("Buneary");
        names.add("Lopunny");
        names.add("Mismagius");
        names.add("Honchkrow");
        names.add("Glameow");
        names.add("Purugly");
        names.add("Chingling");
        names.add("Stunky");
        names.add("Skuntank");
        names.add("Bronzor");
        names.add("Bronzong");
        names.add("Bonsly");
        names.add("Mime Jr.");
        names.add("Happiny");
        names.add("Chatot");
        names.add("Spiritomb");
        names.add("Gible");
        names.add("Gabite");
        names.add("Garchomp");
        names.add("Munchlax");
        names.add("Riolu");
        names.add("Lucario");
        names.add("Hippopotas");
        names.add("Hippowdon");
        names.add("Skorupi");
        names.add("Drapion");
        names.add("Croagunk");
        names.add("Toxicroak");
        names.add("Carnivine");
        names.add("Finneon");
        names.add("Lumineon");
        names.add("Mantyke");
        names.add("Snover");
        names.add("Abomasnow");
        names.add("Weavile");
        names.add("Magnezone");
        names.add("Lickilicky");
        names.add("Rhyperior");
        names.add("Tangrowth");
        names.add("Electivire");
        names.add("Magmortar");
        names.add("Togekiss");
        names.add("Yanmega");
        names.add("Leafeon");
        names.add("Glaceon");
        names.add("Gliscor");
        names.add("Mamoswine");
        names.add("Porygon-Z");
        names.add("Gallade");
        names.add("Probopass");
        names.add("Dusknoir");
        names.add("Froslass");
        names.add("Rotom");
        names.add("Uxie");
        names.add("Mesprit");
        names.add("Azelf");
        names.add("Dialga");
        names.add("Palkia");
        names.add("Heatran");
        names.add("Regigigas");
        names.add("Giratina");
        names.add("Cresselia");
        names.add("Phione");
        names.add("Manaphy");
        names.add("Darkrai");
        names.add("Shaymin");
        names.add("Arceus");
        names.add("Victini");
        names.add("Snivy");
        names.add("Servine");
        names.add("Serperior");
        names.add("Tepig");
        names.add("Pignite");
        names.add("Emboar");
        names.add("Oshawott");
        names.add("Dewott");
        names.add("Samurott");
        names.add("Patrat");
        names.add("Watchog");
        names.add("Lillipup");
        names.add("Herdier");
        names.add("Stoutland");
        names.add("Purrloin");
        names.add("Liepard");
        names.add("Pansage");
        names.add("Simisage");
        names.add("Pansear");
        names.add("Simisear");
        names.add("Panpour");
        names.add("Simipour");
        names.add("Munna");
        names.add("Musharna");
        names.add("Pidove");
        names.add("Tranquill");
        names.add("Unfezant");
        names.add("Blitzle");
        names.add("Zebstrika");
        names.add("Roggenrola");
        names.add("Boldore");
        names.add("Gigalith");
        names.add("Woobat");
        names.add("Swoobat");
        names.add("Drilbur");
        names.add("Excadrill");
        names.add("Audino");
        names.add("Timburr");
        names.add("Gurdurr");
        names.add("Conkeldurr");
        names.add("Tympole");
        names.add("Palpitoad");
        names.add("Seismitoad");
        names.add("Throh");
        names.add("Sawk");
        names.add("Sewaddle");
        names.add("Swadloon");
        names.add("Leavanny");
        names.add("Venipede");
        names.add("Whirlipede");
        names.add("Scolipede");
        names.add("Cottonee");
        names.add("Whimsicott");
        names.add("Petilil");
        names.add("Lilligant");
        names.add("Basculin");
        names.add("Sandile");
        names.add("Krokorok");
        names.add("Krookodile");
        names.add("Darumaka");
        names.add("Darmanitan");
        names.add("Maractus");
        names.add("Dwebble");
        names.add("Crustle");
        names.add("Scraggy");
        names.add("Scrafty");
        names.add("Sigilyph");
        names.add("Yamask");
        names.add("Cofagrigus");
        names.add("Tirtouga");
        names.add("Carracosta");
        names.add("Archen");
        names.add("Archeops");
        names.add("Trubbish");
        names.add("Garbodor");
        names.add("Zorua");
        names.add("Zoroark");
        names.add("Minccino");
        names.add("Cinccino");
        names.add("Gothita");
        names.add("Gothorita");
        names.add("Gothitelle");
        names.add("Solosis");
        names.add("Duosion");
        names.add("Reuniclus");
        names.add("Ducklett");
        names.add("Swanna");
        names.add("Vanillite");
        names.add("Vanillish");
        names.add("Vanilluxe");
        names.add("Deerling");
        names.add("Sawsbuck");
        names.add("Emolga");
        names.add("Karrablast");
        names.add("Escavalier");
        names.add("Foongus");
        names.add("Amoonguss");
        names.add("Frillish");
        names.add("Jellicent");
        names.add("Alomomola");
        names.add("Joltik");
        names.add("Galvantula");
        names.add("Ferroseed");
        names.add("Ferrothorn");
        names.add("Klink");
        names.add("Klang");
        names.add("Klinklang");
        names.add("Tynamo");
        names.add("Eelektrik");
        names.add("Eelektross");
        names.add("Elgyem");
        names.add("Beheeyem");
        names.add("Litwick");
        names.add("Lampent");
        names.add("Chandelure");
        names.add("Axew");
        names.add("Fraxure");
        names.add("Haxorus");
        names.add("Cubchoo");
        names.add("Beartic");
        names.add("Cryogonal");
        names.add("Shelmet");
        names.add("Accelgor");
        names.add("Stunfisk");
        names.add("Mienfoo");
        names.add("Mienshao");
        names.add("Druddigon");
        names.add("Golett");
        names.add("Golurk");
        names.add("Pawniard");
        names.add("Bisharp");
        names.add("Bouffalant");
        names.add("Rufflet");
        names.add("Braviary");
        names.add("Vullaby");
        names.add("Mandibuzz");
        names.add("Heatmor");
        names.add("Durant");
        names.add("Deino");
        names.add("Zweilous");
        names.add("Hydreigon");
        names.add("Larvesta");
        names.add("Volcarona");
        names.add("Cobalion");
        names.add("Terrakion");
        names.add("Virizion");
        names.add("Tornadus");
        names.add("Thundurus");
        names.add("Reshiram");
        names.add("Zekrom");
        names.add("Landorus");
        names.add("Kyurem");
        names.add("Keldeo");
        names.add("Meloetta");
        names.add("Genesect");
        names.add("Chespin");
        names.add("Quilladin");
        names.add("Chesnaught");
        names.add("Fennekin");
        names.add("Braixen");
        names.add("Delphox");
        names.add("Froakie");
        names.add("Frogadier");
        names.add("Greninja");
        names.add("Bunnelby");
        names.add("Diggersby");
        names.add("Fletchling");
        names.add("Fletchinder");
        names.add("Talonflame");
        names.add("Scatterbug");
        names.add("Spewpa");
        names.add("Vivillon");
        names.add("Litleo");
        names.add("Pyroar");
        names.add("Flabébé");
        names.add("Floette");
        names.add("Florges");
        names.add("Skiddo");
        names.add("Gogoat");
        names.add("Pancham");
        names.add("Pangoro");
        names.add("Furfrou");
        names.add("Espurr");
        names.add("Meowstic");
        names.add("Honedge");
        names.add("Doublade");
        names.add("Aegislash");
        names.add("Spritzee");
        names.add("Aromatisse");
        names.add("Swirlix");
        names.add("Slurpuff");
        names.add("Inkay");
        names.add("Malamar");
        names.add("Binacle");
        names.add("Barbaracle");
        names.add("Skrelp");
        names.add("Dragalge");
        names.add("Clauncher");
        names.add("Clawitzer");
        names.add("Helioptile");
        names.add("Heliolisk");
        names.add("Tyrunt");
        names.add("Tyrantrum");
        names.add("Amaura");
        names.add("Aurorus");
        names.add("Sylveon");
        names.add("Hawlucha");
        names.add("Dedenne");
        names.add("Carbink");
        names.add("Goomy");
        names.add("Sliggoo");
        names.add("Goodra");
        names.add("Klefki");
        names.add("Phantump");
        names.add("Trevenant");
        names.add("Pumpkaboo");
        names.add("Gourgeist");
        names.add("Bergmite");
        names.add("Avalugg");
        names.add("Noibat");
        names.add("Noivern");
        names.add("Xerneas");
        names.add("Yveltal");
        names.add("Zygarde");
        names.add("Diancie");
        names.add("Hoopa");
        names.add("Volcanion");
        //endregion

        pokeSprite.setVisibility(View.INVISIBLE);
        url = "http://pokeapi.co/api/v2/pokemon/";
        spriteUrl = "https://img.pokemondb.net/sprites/x-y/normal/";
        randomMon = (((int) (Math.random() * 721)) + 1);
        fullUrl = (url + randomMon);
        fullSpriteUrl = (spriteUrl + randomMon + ".png");

        //questionText.setVisibility(View.GONE);

        Log.d("pokeSprite", "" + randomMon);
        score = 0;
        scoreText.setText("Score: " + score);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered(answer1);
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered(answer2);
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered(answer3);
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered(answer4);
            }
        });

//        answer1.setVisibility(View.GONE);
//        answer2.setVisibility(View.GONE);
//        answer3.setVisibility(View.GONE);
//        answer4.setVisibility(View.GONE);
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);

        new MyTask().execute(fullUrl);
    }

    public void answered(Button button) {
        if (button.getText().equals(pNam)) {
            score++;
            Toast.makeText(IGiveUp.this, "Great Job!", Toast.LENGTH_SHORT).show();
        } else {
            score--;
            Toast.makeText(IGiveUp.this, "The correct answer was " + pNam, Toast.LENGTH_SHORT).show();
        }

//        questionText.setVisibility(View.GONE);
//        answer1.setVisibility(View.GONE);
//        answer2.setVisibility(View.GONE);
//        answer3.setVisibility(View.GONE);
//        answer4.setVisibility(View.GONE);
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);

        randomMon = (((int) (Math.random() * 721)) + 1);
        fullUrl = (url + randomMon);
        new MyTask().execute(fullUrl);
        scoreText.setText("Score: " + score);
        pokeSprite.setY(scoreText.getY()+200);
        pokeSprite.setVisibility(View.VISIBLE);
        hidenSprite.setY(scoreText.getY()+200);
        hidenSprite.setVisibility(View.INVISIBLE);


    }

    private class MyTask extends AsyncTask<String, Void, String> {

        private String jsonFile = "";

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String z;
                while ((z = bufferedReader.readLine()) != null) {
                    jsonFile += z;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("k", jsonFile);
            try {
                a = new JSONObject(jsonFile);
            } catch (JSONException e) {
                e.printStackTrace();
            }



/*String all = ""; 
 for (int randomMon = 0; randomMon<a.optJSONArray("results").length(); randomMon++)
 { randomMon = a.optJSONArray("results").length(); 
all += a.optJSONArray("results").optJSONObject(randomMon).optString("name") + "the" + a.optJSONArray("results").optJSONObject(randomMon).optString("species"); 
 } 
if(a!= null) return all; */
            //  a.optJSONArray("results").optJSONObject(0).optString("name");
            pNam = a.optString("name");
            pokemon = new Pokemon(a.optString("name"), a.optInt("weight"));



            if(question.returnType()==0)
            return a.optString("name");
            return a.optString("weight");
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pokeSprite.setVisibility(View.INVISIBLE);
            hidenSprite.setVisibility(View.INVISIBLE);
            fullSpriteUrl = (spriteUrl + pNam + ".png");
            Glide.with(IGiveUp.this).load(fullSpriteUrl).into(new GlideDrawableImageViewTarget(pokeSprite) {
                @Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                    super.onResourceReady(resource, null); // ignores animation, but handles GIFs properly.
                }
            });
            Glide.with(IGiveUp.this).load(fullSpriteUrl).into(new GlideDrawableImageViewTarget(hidenSprite) {
                @Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                    super.onResourceReady(resource, null); // ignores animation, but handles GIFs properly.
                }
            });
            Glide.with(IGiveUp.this).load(fullSpriteUrl).into(new GlideDrawableImageViewTarget(pokeSprite) {
                @Override public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                    super.onResourceReady(resource, null); // ignores animation, but handles GIFs properly.
                }
            });
            hidenSprite.setColorFilter(Color.BLACK);

            Log.d("d", "dthdtfmhfnjf" + s);
            fullSpriteUrl = (url + pNam + ".png");
            if(question.returnType()==0)
            questionText.setText(question.returnQuestion() + randomMon + "?");
            else if(question.returnType()==1){
                double weight = ((double) Integer.parseInt(s))/10;
                questionText.setText(question.returnQuestion() + weight + " kg?");
            }
            else{
                questionText.setText(question.returnQuestion());
                hidenSprite.setVisibility(View.VISIBLE);
            }

            answerSetupType = (int) (Math.random() * 4);
            if (pNam != null) {
                if (answerSetupType == 0) {
                    answer1.setText(pNam);
                    do
                        answer2.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer2.getText().equals(answer1.getText()));
                    do
                        answer3.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer3.getText().equals(answer1.getText()) || answer3.getText().equals(answer2.getText()));
                    do
                        answer4.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer4.getText().equals(answer1.getText()) || answer4.getText().equals(answer2.getText()) || answer4.getText().equals(answer3.getText()));
                } else if (answerSetupType == 1) {
                    answer2.setText(pNam);
                    do
                        answer1.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer2.getText().equals(answer1.getText()));
                    do
                        answer3.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer3.getText().equals(answer1.getText()) || answer3.getText().equals(answer2.getText()));
                    do
                        answer4.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer4.getText().equals(answer1.getText()) || answer4.getText().equals(answer2.getText()) || answer4.getText().equals(answer3.getText()));

                } else if (answerSetupType == 2) {
                    answer3.setText(pNam);
                    do
                        answer2.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer2.getText().equals(answer3.getText()));
                    do
                        answer1.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer3.getText().equals(answer1.getText()) || answer1.getText().equals(answer2.getText()));
                    do
                        answer4.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer4.getText().equals(answer1.getText()) || answer4.getText().equals(answer2.getText()) || answer4.getText().equals(answer3.getText()));

                } else {
                    answer4.setText(pNam);
                    do
                        answer2.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer2.getText().equals(answer4.getText()));
                    do
                        answer3.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer3.getText().equals(answer4.getText()) || answer3.getText().equals(answer2.getText()));
                    do
                        answer1.setText(names.get((int) (Math.random() * 720) + 1));
                    while (answer4.getText().equals(answer1.getText()) || answer1.getText().equals(answer2.getText()) || answer1.getText().equals(answer3.getText()));
                }
            }






            Log.wtf("f", fullSpriteUrl);
            //questionText.setVisibility(View.VISIBLE);
            //answer1.setVisibility(View.VISIBLE);
            //answer2.setVisibility(View.VISIBLE);
            //answer3.setVisibility(View.VISIBLE);
            //answer4.setVisibility(View.VISIBLE);

            answer1.setEnabled(true);
            answer2.setEnabled(true);
            answer3.setEnabled(true);
            answer4.setEnabled(true);
            question = new Question();

        }
    }
}
