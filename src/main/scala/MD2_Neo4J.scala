
import org.neo4j.driver.Values.parameters
import org.neo4j.driver.{AuthTokens, Config, GraphDatabase}

object MD2_Neo4J extends App {
  println("Let's connect to our Neo4J database!")
  //Pieslēdzamis pie Neo4J AuraDB datubāzes
  val noSSL = Config.builder().build()
  val pw = "AmGoqlB50RBsLPJXI_ithA1VwOcmy5L4e2YGidbpbgA"

  val user = "neo4j"
  val uri = "neo4j+s://56178ee2.databases.neo4j.io"
  val db = "MD2DataBase"
  val filePath = "src/resources/winemag.csv"

  val driver = GraphDatabase.driver(uri, AuthTokens.basic(user, pw), noSSL)
  println("Opening Session")
 val session = driver.session
  val importQuery = "LOAD CSV WITH HEADERS FROM 'https://raw.githubusercontent.com/jana-fed/DatuApstradesSistemas/master/src/resources/winemag.csv' AS rows " +
    "MERGE (winery:Winery {name: rows.winery}) " +
    "CREATE (province:Province {id: toInteger(rows.id), country: rows.country, province: rows.province}) " +
    "CREATE (description:Description {id: toInteger(rows.id), description: rows.description, points: toInteger(rows.points), variety: rows.variety}) " +
    "CREATE (price:Price {id: toInteger(rows.id), price: toInteger(rows.price)}) " +
    "CREATE (winery)-[:LOCATED]->(province) " +
    "CREATE (winery)-[:PRODUCES]->(description) " +
    "CREATE (winery)-[:PRICE]->(price)"
  val result = session.run(importQuery, parameters())




  println("Closing Session")
  session.close() //Svarīgi ir noslēgt sesiju

}
