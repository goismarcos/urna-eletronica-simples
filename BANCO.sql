-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 29-Nov-2018 às 23:40
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_urna`
--
CREATE DATABASE IF NOT EXISTS `db_urna` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_urna`;

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_inserir_candidatos` (IN `paramNome` VARCHAR(200), IN `paramIdPartido` INT, IN `paramIdCargo` INT, IN `paramNumero` INT)  BEGIN
        DECLARE paramStatus INT(1);

    	DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
    		GET DIAGNOSTICS CONDITION 1 @error_message = MESSAGE_TEXT;
    		SELECT 0 as value_return, @error_message as error_message;
            ROLLBACK;
    	END;

        START TRANSACTION;
        
        SET paramStatus = 1;
        IF ( NOT EXISTS (SELECT * FROM candidatos c WHERE c.numero = paramNumero AND c.statuss = paramStatus AND c.id_cargo = paramIdCargo) ) THEN    
        BEGIN         
            IF ( paramIdCargo = 1 ) THEN
            BEGIN
    			IF (CHAR_LENGTH(paramNumero) = 4 ) THEN
    			BEGIN
    				INSERT INTO candidatos VALUES (NULL, paramNome, paramIdPartido, paramIdCargo, paramNumero, paramStatus);
                    
                    SELECT 1 as value_return, 'Candidato cadastrado com sucesso!!' as error_message;
    			END; 
                ELSE 
                BEGIN
    				SELECT 0 as value_return, 'Número Inválido!!' as error_message;
                END; END IF;	
                
                COMMIT;
            END; END IF;
            
            IF ( paramIdCargo = 2 ) THEN
            BEGIN
    			IF ( CHAR_LENGTH(paramNumero) = 5 ) THEN
    			BEGIN
    				INSERT INTO candidatos VALUES (NULL, paramNome, paramIdPartido, paramIdCargo, paramNumero, paramStatus);
                    
                    SELECT 1 as value_return, 'Candidato cadastrado com sucesso!!' as error_message;
    			END; 
                ELSE 
                BEGIN
    				SELECT 0 as value_return, 'Número Inválido!!' as error_message;
                END; END IF;	
                
                COMMIT;
            END; END IF; 
            
            IF ( paramIdCargo = 3 ) THEN
            BEGIN
    			IF ( CHAR_LENGTH(paramNumero) = 3 ) THEN
    			BEGIN
    				INSERT INTO candidatos VALUES (NULL, paramNome, paramIdPartido, paramIdCargo, paramNumero, paramStatus);
                    
                    SELECT 1 as value_return, 'Candidato cadastrado com sucesso!!' as error_message;
    			END; 
                ELSE 
                BEGIN
    				SELECT 0 as value_return, 'Número Inválido!!' as error_message;
                END; END IF;	
                
                COMMIT;
            END; END IF;
            
            IF ( paramIdCargo = 4 ) THEN
            BEGIN
    			IF ( CHAR_LENGTH(paramNumero) = 2 ) THEN
    			BEGIN
    				INSERT INTO candidatos VALUES (NULL, paramNome, paramIdPartido, paramIdCargo, paramNumero, paramStatus);
                    
                    SELECT 1 as value_return, 'Candidato cadastrado com sucesso!!' as error_message;
    			END; 
                ELSE 
                BEGIN
    				SELECT 0 as value_return, 'Número Inválido!!' as error_message;
                END; END IF;	
                
                COMMIT;
            END; END IF;
            
            IF ( paramIdCargo = 5 ) THEN
            BEGIN
    			IF ( CHAR_LENGTH(paramNumero) = 2 ) THEN
    			BEGIN
    				INSERT INTO candidatos VALUES (NULL, paramNome, paramIdPartido, paramIdCargo, paramNumero, paramStatus);
                    
                    SELECT 1 as value_return, 'Candidato cadastrado com sucesso!!' as error_message;
    			END; 
                ELSE 
                BEGIN
    				SELECT 0 as value_return, 'Número Inválido!!' as error_message;
                END; END IF;	
                
                COMMIT;
            END; END IF;
    	END; 
        ELSE 
        BEGIN
            SELECT 0 as value_return, 'Candidato já cadastrado' as error_message;
        END; END IF;
        
        COMMIT;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_inserir_eleitor` ()  BEGIN

        DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1 @error_message = MESSAGE_TEXT;
            SELECT 0 as value_return, @error_message as error_message;
            ROLLBACK;
        END;
        
        START TRANSACTION;
        
			INSERT INTO `eleitor` (`num_eleitor`, `statuss`) VALUES (NULL, 0);

			SELECT LAST_INSERT_ID () as value_return FROM eleitor;
            
        COMMIT;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_inserir_partido` (IN `paramNome` VARCHAR(200))  BEGIN

        DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1 @error_message = MESSAGE_TEXT;
            SELECT 0 as value_return, @error_message as error_message;
            ROLLBACK;
        END;
        
        START TRANSACTION;
        
            IF NOT EXISTS ( SELECT 1 FROM partido WHERE partido.nome = paramNome AND partido.statuss = 1 ) THEN
            BEGIN
                INSERT INTO partido VALUES( NULL, paramNome, 1 );

                SELECT 1 as value_return, 'Partido inserido com sucesso!!' as error_message;
            END;
            ELSE
            BEGIN
                SELECT 0 as value_return, 'Partido já existe!!' as error_message;
            END;
            END IF;
        
        COMMIT;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_inserir_votos` (IN `paramNumero` INT(11), IN `paramIdCargo` INT(11))  BEGIN
	DECLARE id_candidatos INT;
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		GET DIAGNOSTICS CONDITION 1 @error_message = MESSAGE_TEXT;
		SELECT 0 as value_return, @error_message as error_message;
		ROLLBACK;
	END;            

	START TRANSACTION;    
		
		IF( paramNumero > 0 )THEN
		BEGIN
			SET @id_candidatos = ( SELECT candidatos.id_candidatos FROM candidatos WHERE candidatos.numero = paramNumero AND candidatos.statuss = 1 AND candidatos.id_cargo = paramIdCargo );
		END; 
		ELSE BEGIN			
            SET @id_candidatos = 0;			
		END; END IF;
		
		INSERT INTO votos VALUES( NULL, @id_candidatos, paramIdCargo  );

		SELECT 1 as value_return, 'Voto realizado com sucesso!!' as error_message;
	
	COMMIT;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_relatorio_votos` (IN `paramIdCargo` INT)  BEGIN
	IF( paramIdCargo IS NULL )THEN
    BEGIN
		SET paramIdCargo = 0;
    END; END IF;
    
    SELECT 
        COUNT(0) AS `Total Votos`,
        IF( `votos`.`id_candidato` IS NULL,
			'NULO',
			IF(`votos`.`id_candidato` > 0,			
				CONCAT(
					`candidatos`.`nome`,
					' - ',
					`candidatos`.`numero`,
					' - ',
					`partido`.`nome`
				),
                'BRANCO'
			)            
		) AS `Candidato`
    FROM `votos`
        LEFT JOIN `candidatos` 
			ON `candidatos`.`id_candidatos` = `votos`.`id_candidato`
        LEFT JOIN `partido` 
			ON `partido`.`id_partido` = `candidatos`.`id_partido`
	WHERE 1= 1
		AND ( paramIdCargo = 0
			OR ( paramIdCargo <> 0
				AND votos.id_cargo = paramIdCargo				
            )
        )
    GROUP BY `votos`.`id_candidato`;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_truncate_tabelas` ()  BEGIN

        DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1 @error_message = MESSAGE_TEXT;
            SELECT 0 as value_return, @error_message as error_message;
            ROLLBACK;
        END;
        
        START TRANSACTION;
        
            TRUNCATE TABLE candidatos;
            TRUNCATE TABLE votos;
            UPDATE eleitor SET statuss = 0;
        
        COMMIT;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_candidatos` (IN `paramIdCandidatos` INT)  BEGIN

        DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1 @error_message = MESSAGE_TEXT;
            SELECT 0 as value_return, @error_message as error_message;
            ROLLBACK;
        END;
        
        START TRANSACTION;
        
            IF EXISTS ( SELECT 1 FROM candidatos WHERE candidatos.id_candidatos = paramIdCandidatos ) THEN
            BEGIN
                UPDATE candidatos SET candidatos.statuss = 0 WHERE candidatos.id_candidatos = paramIdCandidatos;

                SELECT 1 as value_return, 'Candidato desativado com sucesso!!' as error_message;
            END;
            ELSE
            BEGIN
                SELECT 0 as value_return, 'Candidato não existe!!' as error_message;
            END;
            END IF;
        
        COMMIT;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_eleitor` (IN `paramNum` INT(11))  BEGIN

        DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1 @error_message = MESSAGE_TEXT;
            SELECT 0 as value_return, @error_message as error_message;
            ROLLBACK;
        END;
        
        START TRANSACTION;
        
            UPDATE eleitor SET statuss = 1 WHERE paramNum = num_eleitor;
        
        COMMIT;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_partido` (IN `paramIdPartido` INT)  BEGIN

        DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1 @error_message = MESSAGE_TEXT;
            SELECT 0 as value_return, @error_message as error_message;
            ROLLBACK;
        END;
        
        START TRANSACTION;
        
            IF EXISTS ( SELECT 1 FROM partido WHERE partido.id_partido = paramIdPartido ) THEN
            BEGIN
                UPDATE partido SET partido.statuss = 0 WHERE partido.id_partido = paramIdPartido;

                SELECT 1 as value_return, 'Partido desativado com sucesso!!' as error_message;
            END;
            ELSE
            BEGIN
                SELECT 0 as value_return, 'Partido não existe!!' as error_message;
            END;
            END IF;
        
        COMMIT;
    END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidatos`
--

CREATE TABLE `candidatos` (
  `id_candidatos` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `id_partido` int(11) NOT NULL,
  `id_cargo` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `statuss` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE `cargo` (
  `id_cargo` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`id_cargo`, `nome`) VALUES
(1, 'Deputado Estadual'),
(2, 'Deputado Federal'),
(3, 'Senador'),
(4, 'Governador'),
(5, 'Presidente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `eleitor`
--

CREATE TABLE `eleitor` (
  `num_eleitor` int(11) NOT NULL,
  `statuss` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `eleitor`
--

INSERT INTO `eleitor` (`num_eleitor`, `statuss`) VALUES
(1, 0),
(2, 1),
(3, 1),
(4, 0),
(5, 0),
(6, 0),
(7, 0),
(8, 0),
(9, 0),
(10, 0),
(11, 0),
(12, 0),
(13, 0),
(14, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `partido`
--

CREATE TABLE `partido` (
  `id_partido` int(11) NOT NULL,
  `nome` varchar(200) NOT NULL,
  `statuss` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `partido`
--

INSERT INTO `partido` (`id_partido`, `nome`, `statuss`) VALUES
(11, '', 0),
(12, 'PT', 1),
(13, 'PMDB', 0),
(14, 'PMDB', 1),
(15, 'SDFSD', 0),
(16, '', 0),
(17, '', 0),
(18, 'PSL', 1),
(19, 'PCQ', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_relatorio`
-- (See below for the actual view)
--
CREATE TABLE `view_relatorio` (
`Total Votos` bigint(21)
,`Candidato` varchar(417)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `votos`
--

CREATE TABLE `votos` (
  `id_votos` int(11) NOT NULL,
  `id_candidato` int(11) DEFAULT NULL,
  `id_cargo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `votos`
--

INSERT INTO `votos` (`id_votos`, `id_candidato`, `id_cargo`) VALUES
(1, 0, 2),
(2, 0, 1),
(3, 0, 3),
(4, 0, 4);

-- --------------------------------------------------------

--
-- Structure for view `view_relatorio`
--
DROP TABLE IF EXISTS `view_relatorio`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_relatorio`  AS  select count(0) AS `Total Votos`,if(isnull(`votos`.`id_candidato`),'NULL',if((`votos`.`id_candidato` > 0),concat(`candidatos`.`nome`,' - ',`candidatos`.`numero`,' - ',`partido`.`nome`),'BRANCO')) AS `Candidato` from ((`votos` left join `candidatos` on((`candidatos`.`id_candidatos` = `votos`.`id_candidato`))) left join `partido` on((`partido`.`id_partido` = `candidatos`.`id_partido`))) group by `votos`.`id_candidato` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `candidatos`
--
ALTER TABLE `candidatos`
  ADD PRIMARY KEY (`id_candidatos`);

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`id_cargo`);

--
-- Indexes for table `eleitor`
--
ALTER TABLE `eleitor`
  ADD PRIMARY KEY (`num_eleitor`);

--
-- Indexes for table `partido`
--
ALTER TABLE `partido`
  ADD PRIMARY KEY (`id_partido`);

--
-- Indexes for table `votos`
--
ALTER TABLE `votos`
  ADD PRIMARY KEY (`id_votos`),
  ADD KEY `idx_idcargo_votos` (`id_cargo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `candidatos`
--
ALTER TABLE `candidatos`
  MODIFY `id_candidatos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `id_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `eleitor`
--
ALTER TABLE `eleitor`
  MODIFY `num_eleitor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `partido`
--
ALTER TABLE `partido`
  MODIFY `id_partido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `votos`
--
ALTER TABLE `votos`
  MODIFY `id_votos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `votos`
--
ALTER TABLE `votos`
  ADD CONSTRAINT `fk_votos_cargo_idcargo` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`) ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
