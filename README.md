# projet_groupe_javaEE
Web Dynamic Project (JavaEE, GlassFish, MySQL)



Projet collaboratif
Objectif

Le projet a pour but de vous faire utiliser les méthodes de développement en groupe, notamment agiles. Il s'agit non seulement d'aboutir à une application qui marche, mais aussi de le faire dans les règles de l'art :

    Partir d'un expression de besoin, qui prend ici la forme de scénarios utilisateur et de leurs tests fonctionnels.
    Organiser le travail : le découper en tâches, estimer leur charge, les répartir entre les membres de l'équipe.
    Effectuer la recette, et dans notre cas, à chaque itération.
    Documenter la conception et le code pour faciliter le développement, et pouvoir le reprendre ultérieurement.
    Utiliser pour cela javadoc et wiki.
    Utiliser un outil de gestion de tickets.
    Utiliser un outil de gestion de version.
    Dans notre cas, git et la plate-forme collaborative github, qui contient en plus un wiki et un outil de suivi de tickets.

Le travail sera fait en 2 groupes, chacun prenant une partie précise en charge (partie = une ressource ou une fonctionnalité).
Sujet

Un centre de formation veut des outils mobiles et Web pour faciliter ses processus. Le SI est utilisé par les étudiants, les formateurs, les gestionnaires, ces trois groupes formant les membres, et les candidats (personnes qui veulent devenir des étudiants et qui remplissent un formulaire de candidature).

    Gestion des projets étudiants.
    Le centre base une grande partie de sa formation sur des projets. Il est donc important de gérer facilement ceux-ci.
        Chaque formateur peut créer un projet multi-équipes, qui résume en un seul lieu le travail de toutes les équipes.
        Tests d'acceptation :
            Un project a un titre, un propriétaire, une date de création, une date limite de rendu, un sujet, and la session de formation concernée.
            Le propriétaire du projet est le formateur l'ayant créé.
            La date de création est positionnée par le système à l'instant présent.
            La date limite de rendu est postérieure à la date de création.
            Le propriétaire peut modifier les titre, date limite et sujet.
            Le projet a une page, avec les détails du projet, la liste des équipes, et les étudiants de la session de formation (promotion) pas encore en équipe pour ce projet.
            Le projet apparait dans l'espace personnel des étudiant et du formateur l'ayant créé, sous la rubrique « projets en cours ».
            Chaque mention d'une équipe et d'un membre a un lien vers la page correspondante.
        Chaque étudiant peut créer une équipe pour un projet multi-équipe, de sorte que le formateur est libéré de cette tâche, et les étudiants peuvent s'organiser.
        Tests d'acceptation :
            Une équipe a un propriétaire, une date de création, et un commentaire optionnel.
            Le propriétaire est automatiquement défini comme le créateur de l'équipe.
            Le propriétaire doit appartenir à la promotion concernée par le projet.
            La date de création est définie par le système.
            Le propriétaire de l'équipe peut ajouter des membres de la promotion en tant que membres de l'équipe.
            Le propriétaire peut retirer des membres (utile en cas d'erreur).
            Un membre d'une équipe ne peut pas être membre d'une autre équipe du même projet.
            Le propriétaire peut mettre à jour le résumé de l'équipe.
            Chaque équipe a une page Web dédiée, avec ses détails et ses membres.
            La page fournit des liens vers le profil des membres et du propriétaire.
            Le projet lié à l'équipe mentionne les membres de celle-ci dans l'espace personnel de l'étudiant, ces membres étant cliquables.
        Chaque membre de l'équipe peut mettre des documents sur la page de l'équipe, de sorte que le formateur et les membres de l'équipe ont à tout moment une vision globale.
        Tests d'acceptation :
            Seul le formateur et les membres de cette équipe ont accès au contenu.
            Les membres de l'équipe fournissent un chemin relatif complet pour le document qu'ils ont mis sur le serveur.
            Le système définit automatiquement une date de création / mise à jour et l'auteur (le membre qui met le document).
            Le répertoire a une structure arborescente consultable.
            Les documents ne peuvent être mis après la date limite du projet.
    Gestion des étudiants.
        Tout le monde peut s'enregistrer en ligne en tant que candidat, de sorte que l'administration est libérée de cette tâche fastidieuse et sujette à erreur.
        Tests d'acceptation :
            Les champs nom, adresse, code postal et prénom et ville, email et mot de passe, un ou deux numéros de téléphone (y compris un mobile) doivent être remplis.
            L'e-mail et mot de passe doivent être confirmés (deux champs d'entrée pour chacun d'eux).
            Le niveau de sécurité du mot de passe est affiché à chaque saisie de caractère.
            Le email est unique : deux candidats ne peuvent pas avoir le même.
            Nom et prénom avec adresse, code postal, ville et le premier numéro de téléphone est unique.
            Lorsque le formulaire est soumis, un mail de confirmation contenant un lien Web est envoyé au candidat.
            Le candidat doit confirmer son inscription via ce lien avant le lendemain (24h).
            Le système met automatiquement le nom en majuscule et capitalise le prénom, en supprimant les espaces inutiles.
            Les souscriptions non confirmées en temps utile sont supprimés de la base de données, afin d'éviter des données incorrectes.
            Le candidat reçoit alors un identifiant.
        Chaque membre peut modifier son profil, pour le garder toujours à jour et libérer l'administration de cette tâche.
        Tests d'acceptation :
            Le membre doit se connecter pour éditer son profil.
            Un lien vers l'édition de profil est inclus dans un menu affiché sur chaque page.
            Un membre ne peut pas modifier le profil d'un autre membre.
            L'administration peut modifier le profil de chaque élève.
            Le membre peut envoyer ou mettre à jour sa photo de visage, dont la taille est limitée à 100 ko.
            Les champs obligatoires du formulaire d'inscription ne peuvent pas être vides.
            Les addresse e-mail peuvent être modifiés, mais doit rester unique parmi tous les e-mails de membres.
        Chaque membre peut renouveler son / son mot de passe en cas d'oubli, afin d'assurer le service, même s'il / elle l'a oublié.
        Tests d'acceptation :
            Un lien pour le faire est affiché dans une zone de connexion sur chaque page.
            Le membre doit saisir son adresse e-mail.
            Un lien lui est envoyé par courriel.
            En cliquant sur le lien, une page avec le nouveau mot de passe à saisir est affiché.
            Le nouveau mot de passe doit être saisi deux fois pour éviter les erreurs de saisie.

