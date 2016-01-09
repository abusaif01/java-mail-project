/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Md. Salahuddin
 */
public class Examples {
//    public void parseMail(Part message)
//{
//            if (
//            (message.isMimeType("text/*")) &&
//            (message.getDisposition() != null && message.getDisposition().equals(Part.INLINE))
//            )
//            {
//                System.out.println((String)message.getContent());
//            }
//            else if (message.isMimeType("multipart/alternative"))
//            {
//                Multipart mp = (Multipart)message.getContent();
//                int partsCount = mp.getCount();
//                //TAKE ONLY THE BEST PART
//                System.out.println((String)mp.getBodyPart(partsCount -1).getContent());
//            }
//            else if ( message.isMimeType( "multipart/*" ) )
//            {
//                Multipart mPart = (Multipart) message.getContent();
//                int partCount = mPart.getCount();
//                for ( int i = 0, row = 0 ; i < partCount ; i++ )
//                {
//                    //PARSEING RECURSIVELY
//                    parseMail(mPart.getBodyPart(i));
//                }
//            }
//            else if ( message.isMimeType( "message/*" ) )
//            {
//                try
//                {
//                    Part part = (Message) message.getContent();
//                    //PARSEING RECURSIVELY
//                    parseMail(part);
//                }
//                catch ( java.lang.SecurityException ex )
//                {
//                    try
//                    {
//                        Part part = (MimeMessage) message.getContent();
//                    //PARSEING RECURSIVELY
//                    parseMail(part);
//                    }
//                    catch ( Exception ex1 )
//                    {
//                    System.out.println(ex1);
//                    }
//                }
//            }
//    else
//    {
//      //THIS IS AN ATTACHMENT
//      //WRITE CODE TO HANDLE ATTACHMENT
//    }
//}

}
