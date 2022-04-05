package github;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import kong.unirest.HttpResponse;
import kong.unirest.HttpStatus;
import kong.unirest.GetRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	public String username;
	public String token;
	public String nom;

	public static void main(String[] args) {
		
		
		// Séance 2 :
		// Q1 : Créez un projet java avec unirest. https://kong.github.io/unirest-java/
		// 		Verifier que tout fonctionne : 
		System.out.println("Hey you !");

		// Q2 : Implémentez l’équivalent de : $ curl https://api.github.com/users/{your username}
		HttpResponse<String> response = Unirest.get("https://api.github.com/users/{user}")
				.routeParam("user", "Juju-sail")
				.asString();
		System.out.println(response.getBody());
		
		// Q3 : Ajouter l’authentification et montrer le nombre de dépôts privés.
		String username1 = "Juju-sail";
		String token_file1 = "secret_token.txt";
		String token1 = "";

		try (BufferedReader br = new BufferedReader(new FileReader(token_file1))) {
			token1 = br.readLine();
			HttpResponse<JsonNode> r = Unirest.get("https://api.github.com/users/{username}")
					.routeParam("username", username1)
					.basicAuth(username1, token1)
					.asJson();
			System.out.println(r.getBody());
			JsonNode node = r.getBody();
			int privateRepos = node.getObject().getInt("total_private_repos");
			System.out.print("number of "+ username1 +"'s private repositories : "+ privateRepos);

		} catch (IOException ex) {
			System.out.println(ex);
		}
		
		
		// Séance 3 & 4 : 
		System.out.println("\n ---------------------------------------------------------------------------------------------------------------------------------------------------------- \n");
		/*
	    	Développer le projet de la dernière fois
	    	Demander un nom d’user GitHub (par défaut votre user)
	    	Imprimer quelques détails pour l’user profile, lister les repos, et demander un repo (par défaut le repo de cours).
	    	Imprimer les détails du repo (y compris le nombre de issues ouverts).
	    	Stockez seulement l’URL pour obtenir le profil de l’user, utilisez le _url de la réponse par la suite.
		*/
		main ju = new main("Juju-sail", "secret_token.txt");
		main secretUser = new main(choixUser(), ju.token);
		
		
		// affiche nom secret :
		JsonNode nodeUser = secretUser.defNode("https://api.github.com/users/{username}", ju.token);
		
		secretUser.defNom(nodeUser);
		System.out.println("Nom de l'utilisateur : " + secretUser.nom);
		
		// affiche nb public repositories de secret :
		System.out.print("Nombre de repertoires public de "+ secretUser.nom +" : "+ secretUser.nbRepertoiresPublic(nodeUser) + "\n");
		
		// liste repertoires public de secret :
		System.out.println("Liste répertoires de " + secretUser.username + " : ");
		System.out.println(secretUser.listeRepertoireUser(ju.token));
		
		// choix d'un repertoire public de secret et affiche ses details :
		secretUser.detailRepertoire(secretUser.nbRepertoiresPublic(nodeUser), ju.token);
			
		/*
		Créer des classes pour : issues, label, comments
	    Étendre l’interface pour afficher les issues d’un repo, les détails d’un issues (y compris les label) et les commentaires.
	    Utilisez un objet Java cette fois, pas un JsonNode.

		 */
		
		// détails d'une issue avec objet java :
		System.out.println("----------------------------------------------------------------------------------------------");
		//System.out.println(secretUser.listeIssuesDetails(ju, "Systemes-Distribues"));
		System.out.println(ju.listeIssuesDetails(ju, "crashtest"));
		
		    
		/*TODO
		 * voir le parsing erreur comme test d'erreur
		 * reste à lire les label
		 * lire les commentaires
		 */

		
		}
		
		
	
	
	// Méthodes :
	
	public main(String username, String token_file) {
		super();
		
		this.username = username;
		
		this.token = "";
		try (BufferedReader br = new BufferedReader(new FileReader(token_file))) {
			this.token = br.readLine();

		} catch (IOException ex) {
			System.out.println("Attention, pas de token pour " + username + "\n");
		}
		
		this.nom = this.username;
	}

	public JsonNode defNode(String url, String tokenn) {
		HttpResponse<JsonNode> rep = Unirest.get(url)
				.routeParam("username", this.username)
				.basicAuth("Juju-sail", tokenn)
				.asJson();
		JsonNode node = rep.getBody();
		return node;
	}

	public String defNom(JsonNode node) {
		try {
			this.nom = node.getObject().getString("name");
		}
		catch(Exception e){
			System.out.println("L'utilisateur n'a pas de nom");
		}
		return this.nom;
	}

	public static String choixUser() {
        System.out.println("saisissez un nom de user Github");
        Scanner saisieUser = new Scanner(System.in);
        String username = saisieUser.nextLine();
        
        HttpResponse<JsonNode> rep = Unirest.get("https://api.github.com/users/{username}")
                .routeParam("username", username)
                //.basicAuth(username, token)
                .asJson();
        JsonNode nodeRepos = rep.getBody();
        
        if (rep.getStatus() == HttpStatus.NOT_FOUND) {
            System.out.println(String.format("L'utilisateur: " + username + " est inconnu"));
            username = choixUser();
        }
        return username;
    }

	public String listeIssue(String repert, String tokenn) {
		HttpResponse<JsonNode> repIssues = Unirest.get("https://api.github.com/repos/{username}/"+repert + "/issues")
				.routeParam("username", this.username)
				.basicAuth("Juju-sail", tokenn)
				.queryString("state", "all")
				.asJson();
		JsonNode nodeIssues = repIssues.getBody();
		JSONArray issuesTab = nodeIssues.getArray();
		String toReturn = "";
		for (Object issue_obj : issuesTab) {
            JSONObject issue = (JSONObject) issue_obj;
            String issueTitle = issue.getString("title");
            toReturn += issueTitle + "\n";
		}
		return toReturn;
	}
	
	public List<String> listeIssues(String tokenn, String repert){
		List<String> toReturn = new ArrayList<String>();
		HttpResponse<JsonNode> repIssues = Unirest.get("https://api.github.com/repos/"+this.username+"/"+repert+"/issues")
				.basicAuth("Juju-sail", tokenn)
				.queryString("state", "all")
				.asJson();
		JsonNode nodeIssues = repIssues.getBody();
		JSONArray issuesTab = nodeIssues.getArray();
		for (Object issue_obj : issuesTab) {
            JSONObject issue = (JSONObject) issue_obj;
            String issueNumber = issue.getString("number");
            toReturn.add(issueNumber);
		}
		return toReturn;
	}
	
	public int nbRepertoiresPublic(JsonNode node) {
		int publicRepos = node.getObject().getInt("public_repos");
		return publicRepos;
	}
	
	public void detailRepertoire(int publicRepos, String tokenn) {
		if(publicRepos > 0) {
			System.out.println("\nSaisissez un nom de repertoire appartennant à " + this.nom);
			Scanner saisieRep = new Scanner(System.in);
			String repert = saisieRep.nextLine();
		
			HttpResponse<JsonNode> repRepo = Unirest.get("https://api.github.com/repos/{username}/"+repert)
					.routeParam("username", this.username)
					.basicAuth("Juju-sail", tokenn)
					.asJson();
			JsonNode nodeRepo = repRepo.getBody();
			String fullNameRep = nodeRepo.getObject().getString("full_name");
			
			System.out.println("nom complet du repertoire choisi : " + fullNameRep);
			System.out.println("Liste des issues dans " + repert + " chez " + this.nom + " : ");
			System.out.println(this.listeIssue(repert, tokenn));
		}
	}
	
	public String listeRepertoireUser(String tokenn) {
		HttpResponse<JsonNode> repRepos = Unirest.get("https://api.github.com/users/{username}/repos")
				.routeParam("username", this.username)
				.basicAuth("Juju-sail", tokenn)
				.asJson();
		JsonNode nodeRepos = repRepos.getBody(); // info récupérée sur github prof, je n'aurais jamais pensé à faire un getBody...
		JSONArray reposTab = nodeRepos.getArray();
		String toReturn = "";
		for (Object repo_obj : reposTab) {
            JSONObject repo = (JSONObject) repo_obj; // idem, je n'aurai pas pensé à convertire en jsonObject
            String repoName = repo.getString("name");
            toReturn += repoName + "\n";
		}
		return toReturn;
	}

	public String listeIssuesDetails(main usertoken, String repert) {
		List<String> liste = this.listeIssues(usertoken.token, repert);
		String toReturn = "";
		for (String string : liste) {
			HttpResponse<Issue> r = Unirest.get("https://api.github.com/repos/"+this.username+"/" + repert + "/issues/"+string)
				    .accept("application/json")
				    .basicAuth(usertoken.username, usertoken.token )
				    .queryString("state", "all")
				    .asObject(Issue.class);
			if(r.getStatus() != HttpStatus.OK) {
				System.out.println("pas bonne requete");
			}
			else {
				
				Issue iss = r.getBody();
				toReturn += iss + "\n";
			}
			
		}
		return toReturn;
	}
	
	
}



