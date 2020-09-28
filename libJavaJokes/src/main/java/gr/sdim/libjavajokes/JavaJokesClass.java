package gr.sdim.libjavajokes;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class JavaJokesClass {
    private JSONArray jokes;
    private String credits;
    private Random rnd;


    public void JavaJokesClass() {
        try {
            JSONObject jokesFile = new JSONObject(JokesJson);
            jokes = jokesFile.getJSONArray("jokes");
            credits = jokesFile.getString("credits");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rnd = new Random(System.nanoTime());
    }

    public String getRandomJoke() {
        if (jokes == null) JavaJokesClass();
        if (jokes != null) {
            try {
                return jokes.getString(rnd.nextInt(jokes.length() - 1));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
        //        return "Jokes list is not populated yet!\n\nAnyway, I'll give you a joke.\n\n- Which is the favorite programmers snack?\n- 3bit!";
    }

    public String getCredits() {
        if (credits.isEmpty() || (credits == null)) {
            return "Jokes app for Udacity Android Developer ND project, Stavros Dimopoulos";
        } else {
            return credits;
        }
    }

    private String JokesJson = "{\n" +
                "  \"credits\":\"Jokes found at https://www.pingdom.com/blog/10-computer-geek-jokes-and-truisms/\",\n" +
                "  \"jokes\": [\n" +
                " \"If it weren't for C, we'd all be programming in BASI and OBOL.\",\n" +
                " \"There are 10 types of people in the world: those who understand binary, and those who don't.\",\n" +
                " \"Computers make very fast, very accurate mistakes.\",\n" +
                " \"An SQL statement walks into a bar and sees two tables. It approaches, and asks 'may I join you?' \",\n" +
                " \"Q: Why is it that programmers always confuse Halloween with Christmas?\\n\\nA: Because 31 OCT = 25 DEC.\\n\",\n" +
                " \"Q: How many programmers does it take to change a light bulb?\\n\\nA: None. It's a hardware problem.\",\n" +
                " \"Two strings walk into a bar and sit down.\\n\\nThe bartender says, 'So what'll it be?',\\n\\nThe first string says, 'I think I'll have a beer quag fulk boorg jdk^CjfdLk jk3s d#f67howe%^U r89nvy~~owmc63^Dz x.xvcu',gb\\n\\n'Please excuse my friend,'\\nthe second string says. 'He isn't null-terminated.'\",\n" +
                " \"I'm not interrupting you, I'm putting our conversation in full-duplex mode.\\n\\n- Antone Roundy\",\n" +
                " \"The programmer got stuck in the shower because the instructions on the shampoo bottle said: Lather, Rinse, Repeat.\\n\\n\",\n" +
                " \"A programmer's wife tells him, 'While you're at the grocery store, buy some eggs.' He never comes back.\",\n" +
                " \"A logician tells a colleague his wife just had a baby.\\n\\n- Is it a boy or a girl?\\n\\n- Yes.\",\n" +
                " \"Q. What is the biggest lie in the entire universe?\\n\\nA. 'I have read and agree to the Terms and Conditions.'\"\n" +
                " ]\n" +
                "}\n";
}
