-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 04 Juin 2017 à 22:52
-- Version du serveur :  10.1.21-MariaDB
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `binome36`
--

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE `note` (
  `id` int(11) NOT NULL,
  `idReceipe` int(11) NOT NULL,
  `title` varchar(30) DEFAULT NULL,
  `note` varchar(300) DEFAULT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `receipe`
--

CREATE TABLE `receipe` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `resume` varchar(300) DEFAULT NULL,
  `details` varchar(1000) DEFAULT NULL,
  `nbPersons` int(11) DEFAULT NULL,
  `complexity` int(11) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `receipe`
--

INSERT INTO `receipe` (`id`, `name`, `resume`, `details`, `nbPersons`, `complexity`, `type`, `image`, `duration`) VALUES
(7, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 3, 'Desert', 'crepes.png', 30),
(8, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 3, 'Desert', 'crepes.png', 30),
(9, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 3, 'Desert', 'crepes.png', 30),
(10, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 3, 'Desert', 'crepes.png', 30),
(11, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(12, 'CrepesS', 'blablablaDelicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(13, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(14, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(15, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(16, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(17, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(18, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(19, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(20, 'Crepes', 'Delicieuse crepes blablablabla', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(21, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(22, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(23, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(24, 'CrepesZ', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(25, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(26, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(27, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Desert', 'crepes.png', 4),
(28, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Dessert', 'crepes.png', 4),
(29, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Dessert', 'crepes.png', 4),
(30, 'Crepes', 'Delicieuse crepes', 'Farine + oeuf + lait + biere', 4, 1, 'Dessert', 'crepes.png', 4),
(31, 'Crepes', 'A good breakfast for weekends and even desserts. Serve rolled up and filled with jam or fruit and whipped cream.', 'In a blender, combine all of the ingredients and pulse for 10 seconds. Place the crepe batter in the refrigerator for 1 hour. This allows the bubbles to subside so the crepes will be less likely to tear during cooking. The batter will keep for up to 48 hours.\r\n\r\nHeat a small non-stick pan. Add butter to coat. Pour 1 ounce of batter into the center of the pan and swirl to spread evenly. Cook for 30 seconds and flip. Cook for another 10 seconds and remove to the cutting board. Lay them out flat so they can cool. Continue until all batter is gone. After they have cooled you can stack them and store in sealable plastic bags in the refrigerator for several days or in the freezer for up to two months. When using frozen crepes, thaw on a rack before gently peeling apart.\r\n\r\n*Savory Variation Add 1/4 teaspoon salt and 1/4 cup chopped fresh herbs, spinach or sun-dried tomatoes to the egg mixture.\r\n\r\n*Sweet Variation Add 21/2 tablespoons sugar, 1 teaspoon vanilla extract and 2 tablespoons of you', 4, 3, 'Desert', 'crepes.jpeg', 30);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `administrator` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `lastName`, `firstName`, `login`, `password`, `email`, `age`, `administrator`) VALUES
(4, 'dodo', 'Dodo', 'Dodo', 'dodo', 'dodo@dodo.com', 22, 1),
(20, 'Romain', 'Romain', 'Romain', 'romain', 'romain@romain.fr', 23, 0),
(21, 'Justine', 'Justine', 'Justine', 'Justine', 'Justine@Justine.fr', 23, 0),
(22, 'Romain', 'Romain', 'Romain', 'romain', 'romain@romain.fr', 23, 0),
(23, 'Justine', 'Justine', 'Justine', 'Justine', 'Justine@Justine.fr', 23, 0),
(24, 'Romain', 'Romain', 'Romain', 'romain', 'romain@romain.fr', 23, 0),
(25, 'Justine', 'Justine', 'Justine', 'Justine', 'Justine@Justine.fr', 23, 0),
(30, 'Romain', 'Romain', 'Romain', 'romain', 'romain@romain.fr', 23, 0),
(32, 'Romain', 'Romain', 'Romain', 'romain', 'romain@romain.fr', 23, 0),
(35, 'Admin', 'Admin', 'Admin', 'Admin', 'admin@cookme.fr', 22, 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idReceipe` (`idReceipe`),
  ADD KEY `idUser` (`idUser`);

--
-- Index pour la table `receipe`
--
ALTER TABLE `receipe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `note`
--
ALTER TABLE `note`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `receipe`
--
ALTER TABLE `receipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`idReceipe`) REFERENCES `receipe` (`id`),
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
