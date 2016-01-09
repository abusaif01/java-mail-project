 public void readMail(String user_name,String password)
    {
          class readMailThread extends Thread
          {
            String user_name,password;
            public readMailThread(String user_name,String password)
              {
                this.user_name=user_name;
                this.password=password;
            }
            @Override
        public void run()
        {
         System.out.println("mp called");
        MailHandler mHandler = new MailHandler();
        mHandler.setProtocol("imap");
        mHandler.setURL("imap.gmail.com");
        mHandler.setUserPassword(user_name,password);
        mHandler.connect();
        mHandler.openFolder("INBOX");
        try
        {
            int cnt = mHandler.getMessageCount();
            int nCnt = mHandler.getNewMessageCount();
            System.out.println(cnt + " "+nCnt);
            System.out.println("printing in mail v panel");
            System.out.println("stoped");
            mHandler.parseMessages(new MailViewPanel(), false);
            mHandler.closeFolder();
            tf_from.setText(mHandler.from);
            tf_to.setText(mHandler.to);
            tf_subject.setText(mHandler.subject);
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
              }

         }


          myThread m3=new myThread();
          readMailThread rmth=new readMailThread(user_name,password);

        //  m3.start();
          rmth.start();

       
    }